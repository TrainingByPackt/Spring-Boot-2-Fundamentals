package com.packt.springboot.basicthymeleaf.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @GetMapping("/blogposts")
    public String renderBlogPostList(Model model) {
        List<BlogPost> blogPosts = blogPostService.findAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "/blogposts/list";
    }

    @GetMapping("/blogposts/new")
    public String initNewBlogPost(
            @ModelAttribute("blogPost") BlogPost blogPost
    ) {
        blogPost.setPublicationDate(LocalDateTime.now());
        return "/blogposts/edit";
    }

    @GetMapping("/blogposts/random")
    public RedirectView displayRandomBlogPost(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashMessage", "Enjoy this post");
        attributes.addAttribute("extraMessage", "This message appears in the query");
        BlogPost blogPost = blogPostService.randomBlogPost();
        return new RedirectView("/blogposts/" + blogPost.getSlug(), true);
    }

    @GetMapping("/blogposts/{slug}")
    public ModelAndView displayBlogPostBySlug(@PathVariable String slug)
            throws BlogPostNotFoundException {
        BlogPost blogPost = blogPostService.findBlogPostBySlug(slug)
                .orElseThrow(() -> new BlogPostNotFoundException("Blog post with slug " + slug + " could not be found"));

        return new ModelAndView("/blogposts/details", "blogPost", blogPost);
    }

    @ModelAttribute
    public void addDefaultAttributes(Model model) {
        int allPostsCount = blogPostService.numberOfBlogPosts();
        model.addAttribute("allPostsCount", allPostsCount);
    }
}

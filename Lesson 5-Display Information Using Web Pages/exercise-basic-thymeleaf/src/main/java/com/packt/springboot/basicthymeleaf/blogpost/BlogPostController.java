package com.packt.springboot.basicthymeleaf.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @GetMapping("/")
    public ModelAndView listBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.findAllBlogPosts();
        return new ModelAndView("/blogposts/list", "blogPosts", blogPosts);
    }

    @PostMapping("/")
    public RedirectView addBlogPost() {
        blogPostService.addBlogPost(
                new BlogPost(LocalDateTime.now(),
                        "added-post",
                        "An fresh post",
                        "This post has been added.")
        );

        return new RedirectView("/", true);
    }

    @PostMapping("/clear")
    public RedirectView deleteAllBlogPosts() {
        blogPostService.deleteAllBlogPosts();

        return new RedirectView("/", true);
    }
    // Insert displaySampleBlogPost() here
    @GetMapping("/sample-post")
    public ModelAndView displaySampleBlogPost() {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("A sample blog post");
        blogPost.setPublicationDate(LocalDateTime.now());

        blogPost.setContent("Writing blog posts is fun!");

        return new ModelAndView("/blogposts/details", "blogPost", blogPost);
    }
}

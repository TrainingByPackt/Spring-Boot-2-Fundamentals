package com.packt.springboot.blogmania.blogpost;

import com.packt.springboot.blogmania.author.Author;
import com.packt.springboot.blogmania.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;
    private final AuthorService authorService;

    @GetMapping("/new")
    public String prepareNewBlogPost(Model model) {
        model.addAttribute("blogPost", blogPostService.prepareNewBlogPost());
        model.addAttribute("authors", authorService.findAll());

        return "blogposts/form";
    }

    @PostMapping
    public String saveBlogPost(BlogPost blogPost) {
        Author selectedAuthor = authorService.findById(blogPost.getAuthor().getId());
        blogPost.setAuthor(selectedAuthor);
        blogPost.setPostDate(LocalDateTime.now());
        blogPostService.save(blogPost);
        return "redirect:/";
    }

    @ModelAttribute
    public void addDefaultAttributes(Model model) {
        int allPostsCount = blogPostService.numberOfBlogPosts();
        model.addAttribute("allPostsCount", allPostsCount);
    }
}

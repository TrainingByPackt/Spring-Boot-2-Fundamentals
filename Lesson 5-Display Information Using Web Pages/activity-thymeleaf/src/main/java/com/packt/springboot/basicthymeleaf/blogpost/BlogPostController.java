package com.packt.springboot.basicthymeleaf.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @GetMapping("/")
    public String renderBlogPostList(Model model) {
        List<BlogPost> blogPosts = blogPostService.findAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "/blogposts/list";
    }

    @ModelAttribute
    public void addDefaultAttributes(Model model) {
        int allPostsCount = blogPostService.numberOfBlogPosts();
        model.addAttribute("allPostsCount", allPostsCount);
    }
}

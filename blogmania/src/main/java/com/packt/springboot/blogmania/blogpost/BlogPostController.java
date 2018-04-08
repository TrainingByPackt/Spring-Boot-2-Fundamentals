package com.packt.springboot.blogmania.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogposts")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @GetMapping("/new")
    public String prepareNewBlogPost(Model model) {
        model.addAttribute(
                "blogPost",
                blogPostService.prepareNewBlogPost()
        );

        return "blogposts/form";
    }

    @PostMapping
    public String saveBlogPost(BlogPost blogPost) {
        blogPostService.save(blogPost);
        return "redirect:/";
    }

}

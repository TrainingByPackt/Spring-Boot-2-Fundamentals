package com.packt.springboot.blogmania.homepage;

import com.packt.springboot.blogmania.blogpost.BlogPost;
import com.packt.springboot.blogmania.blogpost.BlogPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final BlogPostService blogPostService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<BlogPost> blogPosts = blogPostService.findAllBlogPosts();

        model.addAttribute("blogPosts", blogPosts);

        return "index";
    }

    @ModelAttribute
    public void addDefaultAttributes(Model model) {
        int allPostsCount = blogPostService.numberOfBlogPosts();
        model.addAttribute("allPostsCount", allPostsCount);
    }

}

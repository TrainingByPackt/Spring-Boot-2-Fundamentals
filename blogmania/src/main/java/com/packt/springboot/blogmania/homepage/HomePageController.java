package com.packt.springboot.blogmania.homepage;

import com.packt.springboot.blogmania.blogpost.BlogPost;
import com.packt.springboot.blogmania.blogpost.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final BlogPostRepository blogPostRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<BlogPost> blogPosts = blogPostRepository.findAll();

        model.addAttribute("blogPosts", blogPosts);

        return "index";
    }
}

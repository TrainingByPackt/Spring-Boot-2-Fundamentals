package com.packt.springboot.blogmania.homepage;

import com.packt.springboot.blogmania.blogpost.BlogPost;
import com.packt.springboot.blogmania.blogpost.BlogPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam Optional<String> error) {
        if (error.isPresent()) {
            log.info("Incorrect login, warning the user");
            model.addAttribute("loginError", "true");
        }
        return "login";
    }

}

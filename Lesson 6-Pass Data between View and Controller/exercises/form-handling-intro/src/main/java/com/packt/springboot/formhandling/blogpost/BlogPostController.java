package com.packt.springboot.formhandling.blogpost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogposts")
@Slf4j
public class BlogPostController {

    @GetMapping("new-multiple-values")
    public String renderFormViewForSeparateValues(Model model) {
        model.addAttribute("title", "Default Title");
        model.addAttribute("slug", "default-slug");
        model.addAttribute("content", "I always wanted to say...");
        return "blogposts/form-multiple-values";
    }

    // Insert createBlogPostFromMultipleValues() here

    // Insert renderFormViewForBackingBean()

    // Insert createBlogPostFromBackingBean()

    // Insert renderFormViewForValidatedBean()

    // Insert createBlogPostFromValidatedBean()

    private BlogPost createBlogPost(String title, String slug, String content, boolean visible) {
        BlogPost createdBlogPost = new BlogPost(
                LocalDateTime.now(),
                title,
                slug,
                content,
                visible);

        log.info("Created blog post {}", createdBlogPost);

        return createdBlogPost;
    }

}

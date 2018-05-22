package com.packt.springboot.input.inputtype;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BlogPostController {
    @GetMapping
    public ModelAndView renderForm() {
        return new ModelAndView("blogpostform", "blogPost", initBlogPost());
    }

    @PostMapping
    public ModelAndView updateForm(@ModelAttribute BlogPost blogPost) {
        return new ModelAndView("blogpostform", "blogPost", blogPost);
    }

    private BlogPost initBlogPost() {
        return new BlogPost();
    }
}

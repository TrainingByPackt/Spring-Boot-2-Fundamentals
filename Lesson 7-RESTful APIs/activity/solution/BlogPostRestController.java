package com.packt.springboot.blogmania.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
@RequiredArgsConstructor
public class BlogPostRestController {
    private final BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> listBlogPosts() {
        return blogPostService.findAllBlogPosts();
    }

}

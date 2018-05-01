package com.packt.springboot.basicthymeleaf.blogpost;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts;
    private Random random;

    @PostConstruct
    public void init() {
        blogPosts = new ArrayList<>();
        blogPosts.add(
                new BlogPost(LocalDateTime.now(),
                        "my-first-post",
                        "First Blog Post",
                        "This is my first blog post!"));
        blogPosts.add(
                new BlogPost(LocalDateTime.now(),
                        "my-second-post",
                        "Second Blog Post",
                        "This is my second blog post!")
        );
        blogPosts.add(
                new BlogPost(LocalDateTime.now(),
                        "my-third-post",
                        "Third Blog Post",
                        "This is my third blog post!")
        );

        random = new Random(System.currentTimeMillis());
    }

    public List<BlogPost> findAllBlogPosts() {
        return blogPosts;
    }

    public int numberOfBlogPosts() {
        return blogPosts.size();
    }

    public BlogPost randomBlogPost() {
        int randomIndex = random.nextInt(blogPosts.size());

        return blogPosts.get(randomIndex);
    }

    public Optional<BlogPost> findBlogPostBySlug(String slug) {
        return blogPosts.stream()
                .filter(blogPost -> slug.equals(blogPost.getSlug()))
                .findFirst();
    }

    public void addBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }

    public void deleteAllBlogPosts() {
        blogPosts.clear();
    }
}

package com.packt.springboot.blogmania.blogpost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostFactory blogPostFactory;
    private final BlogPostRepository blogPostRepository;
    private final Random random = new Random(System.currentTimeMillis());

    public BlogPost prepareNewBlogPost() {
        BlogPost blogPost = blogPostFactory.createBlogPostWithDefaults();

        return blogPost;
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> findAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public int numberOfBlogPosts() {
        return blogPostRepository.countAllBlogPosts();
    }

    public BlogPost randomBlogPost() {
        List<BlogPost> allBlogPosts = findAllBlogPosts();
        int indexOfBlogPost = random.nextInt(numberOfBlogPosts());

        return allBlogPosts.get(indexOfBlogPost);
    }

    public Optional<BlogPost> findBlogPostBySlug(String slug) {
        return blogPostRepository.findBySlug(slug);
    }
}

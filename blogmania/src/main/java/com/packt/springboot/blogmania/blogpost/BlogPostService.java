package com.packt.springboot.blogmania.blogpost;

import com.packt.springboot.blogmania.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostFactory blogPostFactory;
    private final BlogPostRepository blogPostRepository;
    private final Author loggedInAuthor;


    public BlogPost prepareNewBlogPost() {
        BlogPost blogPost = blogPostFactory.createBlogPostWithDefaults();
        blogPost.setAuthor(loggedInAuthor);

        return blogPost;
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}

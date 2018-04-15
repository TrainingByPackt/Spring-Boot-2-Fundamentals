package com.packt.springboot.blogmania.blogpost;

import java.util.List;
import java.util.Optional;

public interface BlogPostRepository {
    List<BlogPost> findAll();

    BlogPost save(BlogPost blogPost);

    int countAllBlogPosts();

    Optional<BlogPost> findBySlug(String slug);
}

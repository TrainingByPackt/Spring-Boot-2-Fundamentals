package com.packt.springboot.blogmania.blogpost;

import java.util.List;

public interface BlogPostRepository {
    List<BlogPost> findAll();

    BlogPost save(BlogPost blogPost);
}

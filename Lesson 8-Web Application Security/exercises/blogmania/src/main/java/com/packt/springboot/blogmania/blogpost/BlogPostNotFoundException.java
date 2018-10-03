package com.packt.springboot.blogmania.blogpost;

public class BlogPostNotFoundException extends Exception {
    public BlogPostNotFoundException(String message) {
        super(message);
    }
}

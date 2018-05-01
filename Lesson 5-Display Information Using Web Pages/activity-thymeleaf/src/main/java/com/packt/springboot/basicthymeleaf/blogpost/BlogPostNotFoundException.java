package com.packt.springboot.basicthymeleaf.blogpost;

public class BlogPostNotFoundException extends Exception {
    public BlogPostNotFoundException(String message) {
        super(message);
    }
}

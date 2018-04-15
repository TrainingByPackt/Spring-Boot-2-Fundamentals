package com.packt.springboot.blogmania.blogpost;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BlogPostExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BlogPostNotFoundException.class)
    protected ResponseEntity<Object> handleBlogPostNotFound(BlogPostNotFoundException ex, WebRequest request) {
        String bodyContent = ex.getMessage();
        return handleExceptionInternal(ex, bodyContent,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}

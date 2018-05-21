package com.packt.springboot.formhandling.blogpost;

import lombok.Value;

import java.time.LocalDateTime;

/**
 * This class represents a blog post model as it would be used by the server to perform business operations and pass
 * it to the view to be rendered.
 */
@Value
public class BlogPost {
    private final LocalDateTime created;

    private final String title;

    private final String slug;

    private final String content;

    private final boolean visible;
}

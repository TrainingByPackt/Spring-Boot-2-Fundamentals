package com.packt.springboot.formhandling.blogpost;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class implements a backing bean to be used by a form when submitting data to the server backend.
 */
@Data
@NoArgsConstructor
public class BlogPostCommand {
    private String title;

    private String slug;

    private String content;

    private boolean visible;
}

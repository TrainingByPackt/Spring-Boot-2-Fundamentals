package com.packt.springboot.formhandling.blogpost;

import lombok.Data;

/**
 * This class implements a backing bean to be used by a form when submitting data to the server backend.
 */
@Data
public class CreateBlogPostCommand {
    private String title;

    private String slug;

    private String content;

    private boolean visible;
}

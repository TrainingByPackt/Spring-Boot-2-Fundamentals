package com.packt.springboot.formhandling.blogpost;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This is an enhanced version of {@link CreateBlogPostCommand} with added validation annotations.
 */
@Data
public class CreateValidatedBlogPostCommand {
    @NotBlank
    @Size(max = 140)
    private String title;

    @Size(min = 3, max = 60, message = "{slug.size}")
    private String slug;

    @NotBlank
    private String content;

    private boolean visible;
}

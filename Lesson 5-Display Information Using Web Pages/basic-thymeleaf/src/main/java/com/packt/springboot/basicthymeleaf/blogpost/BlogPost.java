package com.packt.springboot.basicthymeleaf.blogpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private LocalDateTime publicationDate;

    private String slug;

    private String title;

    private String content;
}

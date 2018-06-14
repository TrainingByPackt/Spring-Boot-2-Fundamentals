package com.packt.springboot.blogmania.blogpost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private Long id;

    private LocalDateTime postDate;

    private String categoryName;

    private String slug;

    private String title;

    private String content;
}

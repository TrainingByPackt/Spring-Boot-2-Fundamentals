package com.packt.springboot.blogmania.blogpost;

import com.packt.springboot.blogmania.author.Author;
import com.packt.springboot.blogmania.category.Category;
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

    private Author author;

    private Category category;

    private boolean featured;

    private PublicationState publicationState;

    private String slug;

    private String title;

    private String content;
}

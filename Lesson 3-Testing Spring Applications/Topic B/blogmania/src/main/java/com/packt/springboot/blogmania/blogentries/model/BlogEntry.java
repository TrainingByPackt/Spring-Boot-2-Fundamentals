package com.packt.springboot.blogmania.blogentries.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogEntry {
    private LocalDateTime date;
    private String title;
    private String abstractText;
    private String body;
    private boolean visible=true;
}

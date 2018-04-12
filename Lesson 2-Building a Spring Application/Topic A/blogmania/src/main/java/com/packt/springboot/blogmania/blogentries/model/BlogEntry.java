package com.packt.springboot.blogmania.blogentries.model;

import lombok.Data;

import java.util.Date;

@Data
public class BlogEntry {
    private Date date;
    private String title;
    private String abstractText;
    private String body;
    private boolean visible=true;
}

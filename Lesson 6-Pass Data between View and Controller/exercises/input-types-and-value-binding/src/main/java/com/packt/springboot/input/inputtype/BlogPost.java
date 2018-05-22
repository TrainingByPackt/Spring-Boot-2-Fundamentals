package com.packt.springboot.input.inputtype;

import lombok.Data;

@Data
public class BlogPost {
    private String title;
    private String slug;
    private String content;
}

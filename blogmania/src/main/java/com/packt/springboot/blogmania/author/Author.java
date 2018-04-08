package com.packt.springboot.blogmania.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}

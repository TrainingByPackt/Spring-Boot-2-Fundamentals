package com.packt.springboot.securityintro.logic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Author {

    private String username;

    private String fullName;

}

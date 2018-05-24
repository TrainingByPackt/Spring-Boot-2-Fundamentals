package com.packt.springboot.securityintro.config;

import com.packt.springboot.securityintro.logic.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SecurityConfiguration {

    @Autowired
    private AuthorService authorService;

}
package com.packt.springboot.blogmania.config;

import com.packt.springboot.blogmania.author.Author;
import com.packt.springboot.blogmania.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthorRepository authorRepository;

    @Bean
    public Author loggedInAuthor() {
        return authorRepository.findById(1L).orElseThrow(() -> new IllegalStateException("Author with id 1 not found"));
    }

}

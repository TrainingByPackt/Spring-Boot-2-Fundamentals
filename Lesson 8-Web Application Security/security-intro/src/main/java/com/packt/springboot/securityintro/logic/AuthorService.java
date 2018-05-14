package com.packt.springboot.securityintro.logic;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthorService {
    private Map<String, Author> authors = new HashMap<>();

    public void add(Author author) {
        authors.put(author.getUsername(), author);
    }
}

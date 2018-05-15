package com.packt.springboot.securityintro.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class AuthorService {
    private Map<String, Author> authors = new HashMap<>();

    /** Low-level access, unsecured */
    void add(Author author) {
        authors.put(author.getUsername(), author);
        log.info("Added {}", author);
    }

    public Optional<Author> byName(String username) {
        return Optional.ofNullable(authors.get(username));
    }

}

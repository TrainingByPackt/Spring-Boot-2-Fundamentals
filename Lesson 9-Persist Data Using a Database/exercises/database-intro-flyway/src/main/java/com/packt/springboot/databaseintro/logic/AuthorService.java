package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final Map<Integer, Author> idLookup = new HashMap<>();
    private final Map<String, Author> nameLookup = new HashMap<>();

    public Optional<Author> lookupByName(String username) {
        try {
            return Optional.of(retrieveAuthor(username));
        } catch (EmptyResultDataAccessException e) {
            log.debug("No result", e);
            return Optional.empty();
        }
    }

    public Author retrieveAuthor(int authorId) {
        Author author = idLookup.get(authorId);
        if (author != null) {
            return author;
        }
        author = authorRepository.retrieveAuthor(authorId);
        nameLookup.put(author.getUsername(), author);
        idLookup.put(author.getId(), author);
        return author;
    }

    public Author retrieveAuthor(String username) {
        Author author = nameLookup.get(username);
        if (author != null) {
            return author;
        }
        author = authorRepository.retrieveAuthor(username);
        nameLookup.put(author.getUsername(), author);
        idLookup.put(author.getId(), author);
        return author;
    }

}

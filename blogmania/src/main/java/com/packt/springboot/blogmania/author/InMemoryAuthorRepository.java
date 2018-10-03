package com.packt.springboot.blogmania.author;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    private List<Author> authors;

    @PostConstruct
    public void init() {
        authors = new ArrayList<>();

        Author demoAuthor1 = new Author(1L, "Toni", "Tester", "toni@tester.de");
        Author demoAuthor2 = new Author(2L, "John", "Doe", "john@doe.com");
        authors.add(demoAuthor1);
        authors.add(demoAuthor2);
    }

    @Override
    public Author save(Author author) {
        authors.add(author);
        return author;
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        Objects.requireNonNull(email, "Email required");

        return authors.stream()
                .filter(author -> email.equals(author.getEmail()))
                .findFirst();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst();
    }

    @Override
    public List<Author> findAll() {
        return new ArrayList<>(authors);
    }
}

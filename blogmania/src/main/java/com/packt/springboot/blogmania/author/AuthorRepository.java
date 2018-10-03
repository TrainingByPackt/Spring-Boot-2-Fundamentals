package com.packt.springboot.blogmania.author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);

    Optional<Author> findAuthorByEmail(String email);

    List<Author> findAll();

    Optional<Author> findById(Long l);
}

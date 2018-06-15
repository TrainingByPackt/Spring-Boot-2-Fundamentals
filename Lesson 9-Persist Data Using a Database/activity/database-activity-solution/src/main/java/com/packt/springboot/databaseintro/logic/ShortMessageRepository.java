package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ShortMessageRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorService authorService;

    public List<ShortMessage> retrieveAll() {
        LinkedMultiValueMap<Integer, Author> authorsMap = new LinkedMultiValueMap<>();
        RowCallbackHandler addAuthor = rs -> authorsMap.add(
                rs.getInt("message_id"),
                authorService.retrieveAuthor(rs.getInt("author_id")));
        jdbcTemplate.query("SELECT message_id, author_id FROM message_authors", addAuthor);

        return jdbcTemplate.query("SELECT id, posted_time, message_text FROM short_message",
                (rs, rowNum) -> {
                    List<Author> authors = authorsMap.get(rs.getInt("id"));
                    LocalDateTime postedTime = rs.getTimestamp("posted_time").toLocalDateTime();
                    String messageText = rs.getString("message_text");
                    return new ShortMessage(authors, postedTime, messageText);
                });
    }
}

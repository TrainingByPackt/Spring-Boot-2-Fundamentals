package com.packt.springboot.databaseintro.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Repository
public class ShortMessageRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorService authorService;

    public ShortMessageRepository(DataSource dataSource, AuthorService authorService) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.authorService = authorService;
    }

    public List<ShortMessage> retrieveAll() {
        return jdbcTemplate.query("SELECT author_id, posted_time, message_text FROM short_message",
                (rs, rowNum) -> {
                    Author author = authorService.retrieveAuthor(rs.getInt("author_id"));
                    LocalDateTime postedTime = rs.getTimestamp("posted_time").toLocalDateTime();
                    String messageText = rs.getString("message_text");
                    return new ShortMessage(author, postedTime, messageText);
                });
    }
}

package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public Author retrieveAuthor(int authorId) {
        return jdbcTemplate.query("SELECT id, username, fullname, password, role " +
                "FROM author a LEFT JOIN role r ON a.id = r.author_id WHERE a.id = ?",
                AuthorRoleBuilder.INSTANCE, authorId);
    }

    public Author retrieveAuthor(String username) {
        return jdbcTemplate.query("SELECT id, username, fullname, password, role " +
                "FROM author a LEFT JOIN role r ON a.id = r.author_id WHERE a.username = ?",
                AuthorRoleBuilder.INSTANCE, username);
    }

    private static class AuthorRoleBuilder implements ResultSetExtractor<Author> {

        static final AuthorRoleBuilder INSTANCE = new AuthorRoleBuilder();

        @Override
        public Author extractData(ResultSet rs) throws SQLException {
            int authorId = 0;
            String username = "";
            String fullname = "";
            String password = ""; // NOSONAR is encrypted
            Set<GrantedAuthority> authorities = new HashSet<>(1);
            while (rs.next()) {
                authorId = rs.getInt("id");
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                password = rs.getString("password");
                authorities.add(Roles.valueOf(rs.getString("role")).getAuthority());
            }
            if (authorities.isEmpty()) {
                throw new EmptyResultDataAccessException("No author of this name, or no authorities", 1);
            }
            return new Author(authorId, username, fullname, password, authorities);
        }
    }

}

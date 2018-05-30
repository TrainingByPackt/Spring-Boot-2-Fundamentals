package com.packt.springboot.databaseintro.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;

@Slf4j
@Repository
public class JdbcDemonstratingRepository {

    private static final String SQL_QUERY = "SELECT 42 FROM dual";

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public JdbcDemonstratingRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void demonstrate() {
        jdbcTemplateSimplest();
        plainJdbcPlainTry();
        plainJdbcTryWithResources();
    }

    public void jdbcTemplateSimplest() {
        Integer result = jdbcTemplate.queryForObject(SQL_QUERY, Integer.class);
        log.info("jdbcTemplateSimplest success {}", result);
    }

    public void jdbcTemplateParametersAndTypes() {
        log.info("{}", jdbcTemplate.queryForObject(
                "SELECT 42 + ? FROM dual", double.class, 8));
        log.info("{}", jdbcTemplate.queryForObject(
                "SELECT now() FROM dual", Timestamp.class));
        log.info("{}", jdbcTemplate.queryForObject(
                "SELECT now() FROM dual", LocalDateTime.class));
    }

    public void jdbcTemplateMoreColumnsOrRows() {
        log.info("{}", jdbcTemplate.queryForList(
                "SELECT fullname FROM author", String.class));
        log.info("{}", jdbcTemplate.queryForMap(
                "SELECT username, fullname FROM author WHERE id = 1"));
        log.info("{}", jdbcTemplate.queryForList(
                "SELECT username, fullname FROM author"));
    }

    public void jdbcTemplateRowMapper() {
        RowMapper<Author> authorRowMapper = (rs, rowNum) -> Author.builder()
                .username(rs.getString("username"))
                .fullName(rs.getString("fullname"))
                .build();
        log.info("{}", jdbcTemplate.query(
                "SELECT username, fullname FROM author", authorRowMapper));
    }

    public void jdbcTemplateUpdate() {
        int updateCount = jdbcTemplate.update(
                "INSERT INTO role(author_id, role) VALUES(4, 'ADMIN')");
        log.info("{} rows updated", updateCount);

        // Warning: This works with H2, but may fail with other JDBC drivers
        // execute() is for DDL only; that is why it returns void
        jdbcTemplate.execute("INSERT INTO role(author_id, role) VALUES(3, 'ADMIN');");
    }

    /**
     * Demonstrate how to insert and retrieve a generated key.
     * <p>
     * The {@code id} column of the {@code short_message} table can generated ids.
     * In order to retrieve the newly generated id, we need an update that returns
     * some data (a JDBC 3 feature). Spring supports this with a keyholder.
     * <p>
     * Unfortunately, {@link JdbcTemplate#update(PreparedStatementCreator, KeyHolder)}
     * needs a {@link PreparedStatementCreator} which is a bit overwhelming
     * here.
     */
    public void insertMessage(Author author, String text) {
        String sql = "INSERT INTO short_message(author_id, posted_time, message_text)" +
                " VALUES(?, ?, ?)";
        Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());

        PreparedStatementCreatorFactory statementCreatorFactory =
                new PreparedStatementCreatorFactory(sql,
                        Types.INTEGER, Types.TIMESTAMP, Types.VARCHAR);
        statementCreatorFactory.setReturnGeneratedKeys(true);
        statementCreatorFactory.setGeneratedKeysColumnNames("id");
        PreparedStatementCreator preparedStatementCreator =
                statementCreatorFactory.newPreparedStatementCreator(
                        new Object[]{author.getId(), currentTimestamp, text});

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        log.info("auto-insert created {} row with key {}", update, keyHolder.getKey());
    }

    public void plainJdbcTryWithResources() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_QUERY)) {
            resultSet.next();
            int result = resultSet.getInt(1);
            log.info("plainJdbcTryWithResources success {}", result);
        } catch (SQLException e) {
            log.error("Some SQL problem, somewhere", e);
        }
    }

    public void plainJdbcPlainTry() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(SQL_QUERY);
                    resultSet.next();
                    int result = resultSet.getInt(1);
                    log.info("plainJdbcTry success {}", result);
                } catch (SQLException e) {
                    log.error("Some SQL problem while executing query or retrieving result", e);
                } finally {
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            log.error("Some SQL problem while closing result set", e);
                        }
                    }
                }
            } catch (SQLException e) {
                log.error("Some SQL problem while creating statement", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        log.error("Some SQL problem while closing statement", e);
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Some SQL problem while getting connection", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("Some SQL problem while closing connection", e);
                }
            }
        }
    }

}

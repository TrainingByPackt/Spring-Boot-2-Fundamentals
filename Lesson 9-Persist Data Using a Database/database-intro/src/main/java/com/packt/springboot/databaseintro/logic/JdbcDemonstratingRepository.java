package com.packt.springboot.databaseintro.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcDemonstratingRepository {

    private static final String SQL_QUERY = "select 42 from dual";

    private final DataSource dataSource;

    @PostConstruct
    public void demonstrate() {
        jdbcTemplateExample();
        plainJdbcPlainTry();
        plainJdbcTryWithResources();
    }

    public void jdbcTemplateExample() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Integer integer = jdbcTemplate.queryForObject(SQL_QUERY, Integer.class);
        log.info("jdbcTemplateExample success {}", integer);
    }

    public void plainJdbcTryWithResources() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_QUERY)) {
            resultSet.next();
            log.info("plainJdbcTryWithResources success {}", resultSet.getInt(1));
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
                    log.info("plainJdbcTryWithResources success {}", resultSet.getInt(1));
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
                log.error("Some SQL problem whiln creating statement", e);
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

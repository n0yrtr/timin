package com.timin;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class TestDataSourceConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/timin";
    private static final String USERNAME = "timinuser";
    private static final String PASSWORD = "timinuser";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }
}
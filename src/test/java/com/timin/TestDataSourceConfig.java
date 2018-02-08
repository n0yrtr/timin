package com.timin;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class TestDataSourceConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }
}
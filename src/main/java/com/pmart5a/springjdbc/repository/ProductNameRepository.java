package com.pmart5a.springjdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductNameRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String script;

    public ProductNameRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.script = read();
    }

    public List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(script, Map.of("name", name), String.class);
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("script.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
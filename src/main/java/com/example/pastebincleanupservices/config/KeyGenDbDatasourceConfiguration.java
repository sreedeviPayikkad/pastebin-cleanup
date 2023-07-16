package com.example.pastebincleanupservices.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class KeyGenDbDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.keygendb")
    public DataSourceProperties keyGenDbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource keyGenDbDataSource() {
        return keyGenDbDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate keyGenDbJdbcTemplate(@Qualifier("keyGenDbDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }




}

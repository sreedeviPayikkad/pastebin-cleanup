package com.example.pastebincleanupservices.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PasteDbDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.pastedb")
    public DataSourceProperties pasteDbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource pasteDbDataSource() {
        return pasteDbDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate pasteDbJdbcTemplate(@Qualifier("pasteDbDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

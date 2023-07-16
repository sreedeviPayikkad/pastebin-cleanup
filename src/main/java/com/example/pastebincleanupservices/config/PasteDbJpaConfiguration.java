package com.example.pastebincleanupservices.config;

import com.example.pastebincleanupservices.model.Paste;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = Paste.class,
        entityManagerFactoryRef = "pasteDbEntityManagerFactory",
        transactionManagerRef = "pasteDbTransactionManager"
)
public class PasteDbJpaConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean pasteDbEntityManagerFactory(
            @Qualifier("pasteDbDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages(Paste.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager pasteDbTransactionManager(
            @Qualifier("pasteDbEntityManagerFactory") LocalContainerEntityManagerFactoryBean pasteDbEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(pasteDbEntityManagerFactory.getObject()));
    }


}


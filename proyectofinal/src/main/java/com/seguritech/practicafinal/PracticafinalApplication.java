package com.seguritech.practicafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@EnableJpaRepositories("com.seguritech.practicafinal.repositories")
@EnableTransactionManagement
public class PracticafinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticafinalApplication.class, args);
    }
}

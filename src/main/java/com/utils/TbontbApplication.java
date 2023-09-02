package com.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TbontbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TbontbApplication.class, args);
    }

}

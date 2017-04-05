package com.rd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rd"})
public class SpringBootOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauth2Application.class, args);
    }
}

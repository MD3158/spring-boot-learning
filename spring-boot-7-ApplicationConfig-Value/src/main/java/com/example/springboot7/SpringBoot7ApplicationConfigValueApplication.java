package com.example.springboot7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot7ApplicationConfigValueApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot7ApplicationConfigValueApplication.class, args);

        DatabaseConnector databaseConnector = context.getBean(DatabaseConnector.class);
        databaseConnector.connect();
    }
}

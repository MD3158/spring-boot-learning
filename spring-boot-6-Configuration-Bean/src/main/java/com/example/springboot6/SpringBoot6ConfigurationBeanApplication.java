package com.example.springboot6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot6ConfigurationBeanApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBoot6ConfigurationBeanApplication.class, args);
        // Lấy ra bean SimpleBean trong Context
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        // In ra màn hình
        System.out.println("Simple Bean Example: " + simpleBean.toString());

        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
        mysql.connect();
    }
}

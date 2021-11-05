package com.example.springboot6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    SimpleBean simpleBeanConfigure(){
        //Khởi tạo một instance của SimpleBean và trả ra ngoài
        return new SimpleBean("Bean được trả");
    }
    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure() {
        DatabaseConnector mySqlConnector = new MySqlConnector();
        mySqlConnector.setUrl("jdbc:mysql://host1:33060/springboot6");
        // Set username, password, format, v.v...
        return mySqlConnector;
    }
}

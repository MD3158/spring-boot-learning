package com.example.springboot5;

import com.example.springboot5.other.OtherGirl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//tìm bean trong other
@ComponentScan("com.example.springboot5.other")
//@SpringBootApplication(scanBasePackages = "com.example.springboot5.other")

//Tìm bean trong nhiều package
//@ComponentScan({"com.example.springboot5.other","com.example.springboot5.other1"})

@SpringBootApplication
public class SpringBoot5ComponentScanApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot5ComponentScanApplication.class, args);
        try {
            Girl girl = context.getBean(Girl.class);
            System.out.println("Bean: " + girl.toString());
        } catch (Exception e) {
            System.out.println("Bean Girl không tồn tại");
        }

        try {
            OtherGirl otherGirl = context.getBean(OtherGirl.class);
            if (otherGirl != null) {
                System.out.println("Bean: " + otherGirl.toString());
            }
        } catch (Exception e) {
            System.out.println("Bean Girl không tồn tại");
        }
    }
}
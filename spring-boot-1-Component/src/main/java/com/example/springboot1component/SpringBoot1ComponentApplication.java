package com.example.springboot1component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot1ComponentApplication {
  public static void main(String[] args) {
    // ApplicationContext chính là container, chứa toàn bộ các Bean
    ApplicationContext context = SpringApplication.run(SpringBoot1ComponentApplication.class, args);

    // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
    // dấu @Component.

    // Lấy Bean ra bằng cách
    Outfit outfit = context.getBean(Outfit.class);

    // In ra để xem thử nó là gì
    System.out.println("Instance: " + outfit);
    // xài hàm wear()
    outfit.wear();
    Girl girl = context.getBean(Girl.class);
    System.out.println("Girl Instance: " + girl);
    System.out.println("Girl outfit: " + girl.outfit);
    girl.outfit.wear();
  }
}

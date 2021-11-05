package com.example.springboot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot4ComponentServiceRepositoryApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBoot4ComponentServiceRepositoryApplication.class, args);

        // Lấy ra bean GirlService
        GirlService girlService = context.getBean(GirlService.class);
        // Lấu ra random một cô gái từ tầng service
        Girl girl = girlService.getRandomGirl();
        // In ra màn hình
        System.out.println(girl);

    }
}
/*Về bản chất thì bạn có thể sử dụng thay thế 3 Annotation @Component, @Service và @Repository cho nhau mà không ảnh hưởng gì tới code của bạn cả. Nó vẫn sẽ hoạt động.
Tuy nhiên từ góc độ thiết kế thì chúng ta cần phân rõ 3 Annotation này cho các Class đảm nhiệm đúng nhiệm vụ của nó.

@Service gắn cho các Bean đảm nhiệm xử lý logic
@Repository gắn cho các Bean đảm nhiệm giao tiếp với DB
@Component gắn cho các Bean khác.*/
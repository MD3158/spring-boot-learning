package com.example.springboot1component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
*/
@Component
@Scope("prototype")
public class Dress implements Outfit{
    @Override
    public void wear(){
    System.out.println("Váy 2 dây");
    }
}

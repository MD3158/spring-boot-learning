package com.example.springboot2autowiredprimaryqualifier;

import org.springframework.stereotype.Component;

@Component
public class Dress implements Outfit {

    @Override
    public void wear() {
        System.out.println("Mặc váy 2 dây");

    }
}

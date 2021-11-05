package com.example.springboot4;

import lombok.Data;


@Data
public class Girl {

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Girl("+ this.name +")";
    }
}

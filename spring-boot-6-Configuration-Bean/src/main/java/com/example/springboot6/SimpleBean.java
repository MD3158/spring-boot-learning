package com.example.springboot6;

import lombok.Data;

/**
 * Một class cơ bản, không sử dụng `@Component`
 */
@Data
public class SimpleBean {
    private String username;

    public SimpleBean(String username) {
        setUsername(username);
    }
    @Override
    public String toString() {
        return "This is a simple bean, name: " + username;
    }
}

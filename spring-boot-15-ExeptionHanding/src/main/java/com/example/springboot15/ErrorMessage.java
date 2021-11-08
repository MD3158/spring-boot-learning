package com.example.springboot15;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ErrorMessage {
    private int statusCode;
    private String message;
}

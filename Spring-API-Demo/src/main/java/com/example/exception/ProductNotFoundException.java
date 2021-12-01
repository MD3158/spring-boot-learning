package com.example.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }
    public ProductNotFoundException(String message){
        super(message);
        this.message = message;
    }
    public ProductNotFoundException(HttpStatus status) {
            this.status = status;
    }
    public ProductNotFoundException() {

    }
}

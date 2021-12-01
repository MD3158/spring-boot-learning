package com.example.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExistsException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }
    public ProductAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
    public ProductAlreadyExistsException(HttpStatus status){
        this.status = status;
    }
    public ProductAlreadyExistsException(){

    }
}

package com.example.exception;

public class ProductAlreadyExistsException extends RuntimeException{
    private String message;

    public ProductAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
    public ProductAlreadyExistsException(){

    }
}

package com.example.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductDto {

    @Id
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message = "Price is mandatory")
    private int price;
}

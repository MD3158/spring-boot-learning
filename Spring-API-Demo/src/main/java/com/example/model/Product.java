package com.example.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    private int id;

    private String name;

    private int price;
}

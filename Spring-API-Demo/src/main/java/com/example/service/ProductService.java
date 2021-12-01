package com.example.service;

import com.example.dto.ProductDto;
import com.example.exception.ProductAlreadyExistsException;
import com.example.exception.ProductNotFoundException;
import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getAll();
    void delete(Integer id) throws ProductNotFoundException;
    Product save(ProductDto productDto) throws ProductAlreadyExistsException;
    Optional<ProductDto> getProductById(Integer id) throws ProductNotFoundException;
    void update(Integer id, ProductDto productDto) throws ProductNotFoundException;
}

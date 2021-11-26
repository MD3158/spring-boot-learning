package com.example.service;

import com.example.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getAll();
    void delete(Integer id);
    void save(ProductDto productDto);
    Optional<ProductDto> findById(Integer id);
}

package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired private ProductService service;
    private ProductDto productDto;
    private Integer id;

    @GetMapping("/products")
    public List<ProductDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable(name = "id") Integer id){
            ProductDto productDto = service.findById(id).get();
            return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }


    @PostMapping("/products")
    public void add(@Valid @RequestBody ProductDto productDto) {
        service.save(productDto);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto productDto, @PathVariable(name = "id") Integer id) {
            ProductDto Product = service.findById(id).get();
            service.save(productDto);
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

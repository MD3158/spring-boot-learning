package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.OptionalInt;

@RestController
public class ProductController {


    @Autowired private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable(name = "id") Integer id){
       return new ResponseEntity(service.getProductById(id), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductDto> add(@Valid @RequestBody ProductDto productDto){
        return new ResponseEntity(service.save(productDto), HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto productDto, @PathVariable(name = "id") Integer id) {
        service.update(id, productDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

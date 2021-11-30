package com.example.controller;

import com.example.dto.ProductDto;
import com.example.exception.ProductAlreadyExistsException;
import com.example.exception.ProductNotFoundException;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

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
        service.save(productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto productDto, @PathVariable(name = "id") Integer id) {
        service.update(id, productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

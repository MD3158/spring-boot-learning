package com.example.service;

import com.example.dto.ProductDto;
import com.example.exception.ProductAlreadyExistsException;
import com.example.exception.ProductNotFoundException;
import com.example.mapper.ProductMapper;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductRepository repo;

    @Autowired private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        if(mapper.modelsToDtos(repo.findAll()).isEmpty()){
            throw new ProductNotFoundException();
        }
        return mapper.modelsToDtos(repo.findAll());
    }

    @Override
    public void delete(Integer id) {
        if (repo.findById(id).isEmpty()){
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
    }

    @Override
    public Product save(ProductDto productDto) {
        if (repo.existsById(productDto.getId())){
            throw new ProductAlreadyExistsException(HttpStatus.BAD_REQUEST);
        }
        return repo.save(mapper.DtoToModel(productDto));
    }



    @Override
    public Optional<ProductDto> getProductById(Integer id){
          if(repo.findById(id).isEmpty()){
              throw new ProductNotFoundException(HttpStatus.NOT_FOUND);
          }
          return Optional.of(mapper.modelToDto(repo.findById(id).get()));
    }
    @Override
    public void update(Integer id, ProductDto productDto){
        if (repo.findById(id).isEmpty()) {
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND);
        }
        Optional<ProductDto> productDtoOptional = Optional.of(mapper.modelToDto(repo.findById(id).get()));
        productDto.setId(productDtoOptional.get().getId());
        repo.save(mapper.DtoToModel(productDto));
    }
}

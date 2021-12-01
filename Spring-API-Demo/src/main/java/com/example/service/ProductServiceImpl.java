package com.example.service;

import com.example.dto.ProductDto;
import com.example.exception.ProductAlreadyExistsException;
import com.example.exception.ProductNotFoundException;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
            throw new ProductNotFoundException();
        }
        repo.deleteById(id);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        if (repo.existsById(productDto.getId())){
            throw new ProductAlreadyExistsException();
        }
        repo.save(mapper.DtoToModel(productDto));
        return productDto;
    }



    @Override
    public ProductDto getProductById(Integer id){
          if(repo.findById(id).isEmpty()){
              throw new ProductNotFoundException();
          } else {
              return mapper.modelToDto(repo.findById(id).get());
          }
    }
    @Override
    public void update(Integer id, ProductDto productDto){
        if (repo.findById(id).isEmpty()) {
            throw new ProductNotFoundException();
        }
        ProductDto list = mapper.modelToDto(repo.findById(id).get());
        list.setName(productDto.getName());
        list.setPrice(productDto.getPrice());
        repo.save(mapper.DtoToModel(list));
    }
}

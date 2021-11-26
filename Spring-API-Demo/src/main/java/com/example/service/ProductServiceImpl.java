package com.example.service;

import com.example.dto.ProductDto;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductRepository repo;

    @Autowired private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        return mapper.modelsToDtos(repo.findAll());
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void save(ProductDto productDto) {
        repo.save(mapper.DtoToModel(productDto));
    }

    @Override
    public Optional<ProductDto> findById(Integer id) {
        return Optional.of(mapper.modelToDto(repo.findById(id).get()));
    }
}

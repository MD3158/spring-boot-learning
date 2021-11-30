package com.example.mapper;

import com.example.dto.ProductDto;
import com.example.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(Product product);

    Product DtoToModel(ProductDto productDto);

    List<ProductDto> modelsToDtos(List<Product> product);

}

package com.inEffigo.crud_with_dto_mappers.mappers;

import com.inEffigo.crud_with_dto_mappers.entity.Product;
import com.inEffigo.crud_with_dto_mappers.entity.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto toDto(Product product){
        return new ProductDto(
                product.getPid(),
                product.getPname(),
                product.getPprice(),
                product.getPdescription()
        );
    }

    public Product toEntity(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription()
        );
    }
}

package com.inEffigo.crud_with_dto_mappers.service;

import com.inEffigo.crud_with_dto_mappers.entity.Product;
import com.inEffigo.crud_with_dto_mappers.entity.ProductDto;
import com.inEffigo.crud_with_dto_mappers.mappers.ProductMapper;
import com.inEffigo.crud_with_dto_mappers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    public ProductDto createProduct(ProductDto productDto){
        Product product = productMapper.toEntity(productDto);
        Product saveProduct = productRepository.save(product);
        return productMapper.toDto(saveProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto){
        Product oldProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        oldProduct.setPname(productDto.getName());
        oldProduct.setPprice(productDto.getPrice());
        oldProduct.setPdescription(productDto.getDescription());

        Product newProduct = productRepository.save(oldProduct);
        return productMapper.toDto(newProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

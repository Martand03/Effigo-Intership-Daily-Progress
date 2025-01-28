package com.inEffigo.customer_many_to_many.service;

import com.inEffigo.customer_many_to_many.entity.Product;
import com.inEffigo.customer_many_to_many.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepo.findById(id);
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProductById(Long id){
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product product1 = getProductById(product.getId()).orElseThrow(()-> new RuntimeException("Product not found"));
        product1.setName(product.getName());
        return productRepo.save(product1);
    }

}

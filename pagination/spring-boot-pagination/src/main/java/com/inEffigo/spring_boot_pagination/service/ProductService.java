package com.inEffigo.spring_boot_pagination.service;

import com.inEffigo.spring_boot_pagination.entity.Product;
import com.inEffigo.spring_boot_pagination.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
//    public void intiDB(){
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100),
//                        new Random().nextInt(5000)))
//                .toList();
//
//        productRepository.saveAll(products);
//    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findProductsWithSorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> findProductWithPagination(int offset, int pageSize){

        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<Product> findProductWithPaginationAndSorting(int offset, int pageSize, String fields){

        return productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(fields)));
    }
}

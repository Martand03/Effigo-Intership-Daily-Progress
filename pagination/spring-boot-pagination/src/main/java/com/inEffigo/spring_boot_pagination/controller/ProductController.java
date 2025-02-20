package com.inEffigo.spring_boot_pagination.controller;

import com.inEffigo.spring_boot_pagination.dto.APIResponse;
import com.inEffigo.spring_boot_pagination.entity.Product;
import com.inEffigo.spring_boot_pagination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public APIResponse<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();

        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/{field}")
    public APIResponse<List<Product>> getAllProductsWithSort(@PathVariable String field){
        List<Product> products = productService.findProductsWithSorting(field);

        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("pagination/{offset}/{pageSize}")
    public APIResponse<Page<Product>> getPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Product> products = productService.findProductWithPagination(offset, pageSize);

        return new APIResponse<>(products.getSize(), products);
    }

    @GetMapping("paginationAndSorting/{offset}/{pageSize}/{field}")
    public APIResponse<Page<Product>> getPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        Page<Product> products = productService.findProductWithPaginationAndSorting(offset, pageSize, field);

        return new APIResponse<>(products.getSize(), products);
    }



}

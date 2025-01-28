package com.inEffigo.customer_many_to_many.repository;

import com.inEffigo.customer_many_to_many.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

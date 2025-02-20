package com.inEffigo.spring_boot_pagination.repository;

import com.inEffigo.spring_boot_pagination.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

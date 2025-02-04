package com.inEffigo.crud_with_dto_mappers.repository;

import com.inEffigo.crud_with_dto_mappers.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

package com.inEffigo.ols_backend_spring.coursematerial.repository;

import com.inEffigo.ols_backend_spring.coursematerial.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

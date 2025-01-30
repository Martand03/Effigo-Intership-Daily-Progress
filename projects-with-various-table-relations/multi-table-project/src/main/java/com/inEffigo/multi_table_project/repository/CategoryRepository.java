package com.inEffigo.multi_table_project.repository;

import com.inEffigo.multi_table_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

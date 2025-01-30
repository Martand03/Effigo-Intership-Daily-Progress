package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.Category;
import com.inEffigo.multi_table_project.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{catId}")
    public ResponseEntity<Category> getCatById(@PathVariable Long catId){
        Category category = categoryService.getCategoryById(catId);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long catId){
        categoryService.deleteCategoryById(catId);
        return ResponseEntity.noContent().build();
    }
}

package com.ecomm.admin.controller;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {

        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        return ResponseEntity.ok().body(categoryService.deleteCategory(id));
    }
}

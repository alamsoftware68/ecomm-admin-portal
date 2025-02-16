package com.ecomm.admin.controller;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
}

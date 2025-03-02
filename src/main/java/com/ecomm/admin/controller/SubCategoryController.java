package com.ecomm.admin.controller;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.model.SubCategory;
import com.ecomm.admin.service.CategoryService;
import com.ecomm.admin.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/subcategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/subcategories")
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/create")
    public SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.createSubCategory(subCategory);
    }

    @PutMapping("/update/{id}")
    public SubCategory updateSubCategory(@PathVariable("id") int id, @RequestBody SubCategory subCategory) {
        return subCategoryService.updateSubCategory(subCategory);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubCategory(@PathVariable("id") int id) {
        subCategoryService.deleteSubCategory(id);
        return "SubCategory deleted successfully";
    }
}

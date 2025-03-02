package com.ecomm.admin.service.impl;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.model.SubCategory;
import com.ecomm.admin.repo.CategoryRepo;
import com.ecomm.admin.repo.SubCategoryRepo;
import com.ecomm.admin.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    @Autowired
    public SubCategoryRepo subCategoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        Category savedCategory = null;
        try {
            savedCategory = categoryRepo.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while saving category: " + e.getMessage());
        }
        return savedCategory;
    }
    @Override
    public Category getCategoryById(int id) {
        Category category = null;
        try {
            category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while retrieving category: " + e.getMessage());
        }
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category updatedCategory = null;
        try {
            Category existingCategory = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setCategoryPriority(category.getCategoryPriority());
            updatedCategory = categoryRepo.save(existingCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating category: " + e.getMessage());
        }
        return updatedCategory;
    }

    @Override
    public String deleteCategory(int id) {
        try {
            Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            List<SubCategory> subCategories = subCategoryRepo.findByCategoryId(id);
            subCategoryRepo.deleteAll(subCategories);
            categoryRepo.delete(category);
            return "Category with id " + id + " and its subcategories are deleted successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting category: " + e.getMessage());
        }
    }
}

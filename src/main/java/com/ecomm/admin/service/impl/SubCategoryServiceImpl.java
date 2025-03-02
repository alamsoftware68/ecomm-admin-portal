package com.ecomm.admin.service.impl;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.model.SubCategory;
import com.ecomm.admin.repo.CategoryRepo;
import com.ecomm.admin.repo.SubCategoryRepo;
import com.ecomm.admin.service.CategoryService;
import com.ecomm.admin.service.SubCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    public SubCategoryRepo subCategoryRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepo.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public SubCategory createSubCategory(SubCategory subCategory) {
        SubCategory savedSubCategory = null;
        try {
            Category category = categoryRepo.findById(subCategory.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            subCategory.setCategoryId(category.getId());
            subCategory.setCategoryName(category.getCategoryName());
            savedSubCategory = subCategoryRepo.save(subCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while saving subCategory: " + e.getMessage());
        }
        return savedSubCategory;
    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory) {
        SubCategory updatedSubCategory = null;
        try {
            SubCategory existingSubCategory = subCategoryRepo.findById(subCategory.getId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));
            existingSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
            existingSubCategory.setSubCategoryPriority(subCategory.getSubCategoryPriority());
            Category category = categoryRepo.findById(subCategory.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingSubCategory.setCategoryId(category.getId());
            existingSubCategory.setCategoryName(category.getCategoryName());
            updatedSubCategory = subCategoryRepo.save(existingSubCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating subCategory: " + e.getMessage());
        }
        return updatedSubCategory;
    }

    @Override
    public String deleteSubCategory(int id) {
        try {
            SubCategory subCategory = subCategoryRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));
            subCategoryRepo.delete(subCategory);
            return "Sub Category with id " + id + " is deleted Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting subCategory: " + e.getMessage());
        }
    }
}

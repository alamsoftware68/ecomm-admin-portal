package com.ecomm.admin.service.impl;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.model.SubCategory;
import com.ecomm.admin.repo.CategoryRepo;
import com.ecomm.admin.repo.SubCategoryRepo;
import com.ecomm.admin.service.CategoryService;
import com.ecomm.admin.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Category category = categoryRepo.findById(subCategory.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        subCategory.setCategoryId(category.getId());
        subCategory.setCategoryName(category.getCategoryName());
        return subCategoryRepo.save(subCategory);
    }
}

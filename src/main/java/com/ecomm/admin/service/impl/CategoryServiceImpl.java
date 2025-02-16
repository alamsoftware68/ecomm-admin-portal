package com.ecomm.admin.service.impl;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.repo.CategoryRepo;
import com.ecomm.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }
}

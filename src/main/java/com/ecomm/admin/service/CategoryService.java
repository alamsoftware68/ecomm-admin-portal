package com.ecomm.admin.service;

import com.ecomm.admin.model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category createCategory(Category category);
}

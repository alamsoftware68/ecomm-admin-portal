package com.ecomm.admin.service;

import com.ecomm.admin.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category getCategoryById(int id);

    Category updateCategory(int id, Category category);

    String deleteCategory(int id);
}

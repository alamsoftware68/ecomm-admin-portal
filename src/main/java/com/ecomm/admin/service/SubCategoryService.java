package com.ecomm.admin.service;

import com.ecomm.admin.model.Category;
import com.ecomm.admin.model.SubCategory;

import java.util.List;

public interface SubCategoryService {

    public List<SubCategory> getAllSubCategories();

    public SubCategory createSubCategory(SubCategory subCategory);



}

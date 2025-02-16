package com.ecomm.admin.model;

import jakarta.persistence.*;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subCategoryName;
    private int subCategoryPriority;
    private int categoryId;
    private String categoryName;

    public SubCategory() {
    }

    public SubCategory(int id, String subCategoryName, int subCategoryPriority, int categoryId, String categoryName) {
        this.id = id;
        this.subCategoryName = subCategoryName;
        this.subCategoryPriority = subCategoryPriority;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public int getSubCategoryPriority() {
        return subCategoryPriority;
    }

    public void setSubCategoryPriority(int subCategoryPriority) {
        this.subCategoryPriority = subCategoryPriority;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", subCategoryPriority=" + subCategoryPriority +
                ", categoryId=" + categoryId +
                ", categoryName=" + categoryName +
                '}';
    }
}

package com.ecomm.admin.model;

public class SubCategoryDTO {
    private String subCategoryName;
    private int subCategoryPriority;
    private int categoryName;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(String subCategoryName, int subCategoryPriority, int categoryName) {
        this.subCategoryName = subCategoryName;
        this.subCategoryPriority = subCategoryPriority;
        this.categoryName = categoryName;
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

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "SubCategoryDTO{" +
                "subCategoryName='" + subCategoryName + '\'' +
                ", subCategoryPriority=" + subCategoryPriority +
                ", categoryName=" + categoryName +
                '}';
    }
}

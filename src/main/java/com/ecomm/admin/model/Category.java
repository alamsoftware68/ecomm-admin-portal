package com.ecomm.admin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;
    private int categoryPriority;

    public Category() {
    }

    public Category(int id, String categoryName, int categoryPriority) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryPriority = categoryPriority;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getCategoryPriority() {
        return categoryPriority;
    }
    public void setCategoryPriority(int categoryPriority) {
        this.categoryPriority = categoryPriority;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryPriority=" + categoryPriority +
                '}';
    }
}

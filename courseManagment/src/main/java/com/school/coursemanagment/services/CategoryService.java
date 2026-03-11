package com.school.coursemanagment.services;

import com.school.coursemanagment.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategoryById(Long id);
    List<Category> getAllCategory();
    Category getCategoryById(Long id);
}

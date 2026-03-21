package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CategoryDTO;
import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Course;

import java.util.List;

public interface CategoryService {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(Long id);
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(Long id);
    List<CourseDTO> getCourseByIdCategory(Long id);
    CategoryDTO convertEntityToDto(Category category);
    Category convertDtoToEntity(CategoryDTO categoryDTO);
}

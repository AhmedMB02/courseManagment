package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CategoryDTO;
import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDTO saveCategory(Category category) {

        return convertEntityToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO updateCategory(Category category) {
        return convertEntityToDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {

        return categoryRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return convertEntityToDto(categoryRepository.getReferenceById(id));
    }

    @Override
    public List<CourseDTO> getCourseByIdCategory(Long id) {
        return categoryRepository.findByIdCategory(id).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO convertEntityToDto(Category category) {
        return CategoryDTO.builder()
                .idCategory(category.getIdCategory())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    @Override
    public Category convertDtoToEntity(CategoryDTO categoryDTO) {
        return null;
    }


}

package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CategoryDTO;
import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.exception.AlreadyExistsException;
import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.repository.CategoryRepository;
import com.school.coursemanagment.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        if(categoryRepository.existsByName(categoryDTO.getName())){
            throw new AlreadyExistsException("Category already exists in database");
        }
        return convertEntityToDto(categoryRepository.save(convertDtoToEntity(categoryDTO)));
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return convertEntityToDto(categoryRepository.save(convertDtoToEntity(categoryDTO)));
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
        return courseRepository.findByCategoryIdCategory(id).stream()
                .map(courseService::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO convertEntityToDto(Category category) {
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public Category convertDtoToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO,Category.class);
    }


}

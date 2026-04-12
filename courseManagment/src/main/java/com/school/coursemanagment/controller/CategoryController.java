package com.school.coursemanagment.controller;

import com.school.coursemanagment.DTO.CategoryDTO;
import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){

        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByCategoryId(@PathVariable Long id){return  categoryService.getCourseByIdCategory(id);}

    @PostMapping("/addcat")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.saveCategory(categoryDTO);
    }

    @PutMapping("/updatecat/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id,@RequestBody CategoryDTO categoryDTO){
        categoryDTO.setIdCategory(id);
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/deletecat/{id}")
    public void deleteCategory(@PathVariable Long id){ categoryService.deleteCategoryById(id);}



}

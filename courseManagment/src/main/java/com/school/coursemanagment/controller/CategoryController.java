package com.school.coursemanagment.controller;

import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByCategoryId(@PathVariable Long id){return  categoryService.getCourseByIdCategory(id);}

    @PostMapping("/addcat")
    public Category createCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping("/updatecat/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
        category.setIdCategory(id);
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/deletecat/{id}")
    public void deleteCategory(@PathVariable Long id){ categoryService.deleteCategoryById(id);}



}

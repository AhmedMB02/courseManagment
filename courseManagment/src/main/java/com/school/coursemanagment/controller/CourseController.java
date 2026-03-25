package com.school.coursemanagment.controller;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseApi")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addcourse")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
        return courseService.saveCourse(courseDTO);
    }

    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }

    @GetMapping("/allcourses")
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("course/{id}")
    public CourseDTO getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PutMapping("/updateCourse")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO){
        return courseService.updateCourse(courseDTO);
    }

}

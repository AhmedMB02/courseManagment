package com.school.coursemanagment.controller;

import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.services.CourseService;
import com.school.coursemanagment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseApi")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addcourse")
    public Course createCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }

    @GetMapping("/allcourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("course/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

}

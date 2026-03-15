package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.model.Course;

import java.util.List;

public interface CourseService {
    CourseDTO saveCourse(Course course);
    CourseDTO updateCourse(Course course);
    void deleteCourseById(Long id);
    List<CourseDTO>getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO convertEntityToDto(Course course);
    Course convertDtoToEntity(CourseDTO courseDTO);
}

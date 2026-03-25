package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.model.Course;

import java.util.List;

public interface CourseService {
    CourseDTO saveCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(CourseDTO courseDTO);
    void deleteCourseById(Long id);
    List<CourseDTO>getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO convertEntityToDto(Course course);
    Course convertDtoToEntity(CourseDTO courseDTO);
}

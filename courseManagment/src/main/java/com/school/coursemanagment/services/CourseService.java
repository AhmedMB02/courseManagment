package com.school.coursemanagment.services;

import com.school.coursemanagment.model.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourseById(Long id);
    List<Course>getAllCourses();
    Course getCourseById(Long id);
}

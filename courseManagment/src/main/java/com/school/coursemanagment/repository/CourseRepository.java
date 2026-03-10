package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}

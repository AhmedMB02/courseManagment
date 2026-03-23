package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByCategoryIdCategory(Long idCategory);
}

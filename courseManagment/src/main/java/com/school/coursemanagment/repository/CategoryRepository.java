package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Course> findByCategoryIdCategory(Long idCategory);
}

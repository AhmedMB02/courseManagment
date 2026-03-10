package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

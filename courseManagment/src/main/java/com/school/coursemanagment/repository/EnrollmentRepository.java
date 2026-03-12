package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

}

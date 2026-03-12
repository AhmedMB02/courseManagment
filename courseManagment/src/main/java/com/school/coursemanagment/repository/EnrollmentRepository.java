package com.school.coursemanagment.repository;

import com.school.coursemanagment.model.Enrollment;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    List<Enrollment> findByUserIdUser(Long idUser);

    List<Enrollment> findByCourseIdCourse(Long idCourse);

    boolean existsByUserIdUserAndCourseIdCourse(Long idUser,Long idCourse);
}

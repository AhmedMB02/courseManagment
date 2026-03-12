package com.school.coursemanagment.services;

import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;

import java.util.List;

public interface EnrollmentService {

    Enrollment enrollStudent(Enrollment enrollment);
    List<Enrollment> getAllEnrollments();
    List<Enrollment> getEnrollmentsByStudent(Long idUser);
    List<Enrollment> getEnrollmentsByCourse(Long idCourse);
    void deleteEnrollment(Long idEnrollment);
    Enrollment getEnrollmentById(Long idEnrollment);
}

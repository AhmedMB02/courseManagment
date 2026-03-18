package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.EnrollmentDTO;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDTOO enrollStudent(Enrollment enrollment);
    List<EnrollmentDTOO> getAllEnrollments();
    List<EnrollmentDTOO> getEnrollmentsByStudent(Long idUser);
    List<EnrollmentDTOO> getEnrollmentsByCourse(Long idCourse);
    void deleteEnrollment(Long idEnrollment);
    EnrollmentDTOO getEnrollmentById(Long idEnrollment);
}

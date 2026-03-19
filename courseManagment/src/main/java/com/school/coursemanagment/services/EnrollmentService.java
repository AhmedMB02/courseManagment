package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.EnrollmentDTO;
import com.school.coursemanagment.DTO.UserDTO;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDTO enrollStudent(Enrollment enrollment);
    List<EnrollmentDTO> getAllEnrollments();
    List<EnrollmentDTO> getEnrollmentsByStudent(Long idUser);
    List<EnrollmentDTO> getEnrollmentsByCourse(Long idCourse);
    void deleteEnrollment(Long idEnrollment);
    EnrollmentDTO getEnrollmentById(Long idEnrollment);
    Enrollment convertDtoToEntity(EnrollmentDTO enrollmentDTO);
}

package com.school.coursemanagment.services;

import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment enrollStudent(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(Long idUser) {
        return null;
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(Long idCourse) {
        return null;
    }

    @Override
    public void deleteEnrollment(Long idEnrollment) {
        enrollmentRepository.deleteById(idEnrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long idEnrollment) {
        return null;
    }
}

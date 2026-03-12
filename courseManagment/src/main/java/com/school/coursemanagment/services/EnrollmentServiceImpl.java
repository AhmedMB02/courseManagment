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
        if (enrollmentRepository.existsByUserIdUserAndCourseIdCourse(enrollment.getUser().getIdUser(),enrollment.getCourse().getIdCourse())){
            throw new RuntimeException("Student already enrolled in this course");
        }
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(Long idUser) {
        return enrollmentRepository.findByUserIdUser(idUser);
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(Long idCourse) {
        return enrollmentRepository.findByCourseIdCourse(idCourse);
    }

    @Override
    public void deleteEnrollment(Long idEnrollment) {
        enrollmentRepository.deleteById(idEnrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long idEnrollment) {
        return enrollmentRepository.getReferenceById(idEnrollment);
    }
}

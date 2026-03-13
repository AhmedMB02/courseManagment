package com.school.coursemanagment.services;

import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.repository.CourseRepository;
import com.school.coursemanagment.repository.EnrollmentRepository;
import com.school.coursemanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Enrollment enrollStudent(Enrollment enrollment) {

        Long idUser = enrollment.getUser().getIdUser();
        System.out.println("--------------User ID = " + enrollment.getUser().getIdUser());
        User user = userRepository.findById(idUser).
                orElseThrow( ()-> new RuntimeException("User not found")
        );

        if(user.getRole()!= Role.student){
            throw new RuntimeException("Only students can enroll in courses");
        }

        Long idCourse = enrollment.getCourse().getIdCourse();
        System.out.println("--------------Course ID = " + enrollment.getCourse().getIdCourse());
        Course course = courseRepository.findById(idCourse)
                .orElseThrow(()->new RuntimeException("Course not found"));

        boolean exist = enrollmentRepository.existsByUserIdUserAndCourseIdCourse(idUser,idCourse);
        if(exist) throw new RuntimeException("Student already enrolled in this course");

        enrollment.setUser(user);
        enrollment.setCourse(course);

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

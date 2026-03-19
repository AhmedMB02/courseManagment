package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.DTO.EnrollmentDTO;
import com.school.coursemanagment.DTO.UserDTO;
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
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public EnrollmentDTO enrollStudent(Enrollment enrollment) {

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

        return convertEntityToDto(enrollmentRepository.save(enrollment));

    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {

        return enrollmentRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByStudent(Long idUser) {
        return enrollmentRepository.findByUserIdUser(idUser)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByCourse(Long idCourse) {
        return enrollmentRepository.findByCourseIdCourse(idCourse)
                .stream().map(this::convertEntityToDto)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void deleteEnrollment(Long idEnrollment) {
        enrollmentRepository.deleteById(idEnrollment);
    }

    @Override
    public EnrollmentDTO getEnrollmentById(Long idEnrollment) {
        return convertEntityToDto(enrollmentRepository.getReferenceById(idEnrollment));
    }

    @Override
    public Enrollment convertDtoToEntity(EnrollmentDTO enrollmentDTO) {
        return null;
    }

    // ✅ méthode manquante
    private EnrollmentDTO convertEntityToDto(Enrollment enrollment) {
        return EnrollmentDTO.builder()
                .id(enrollment.getId())
                .enrollmentDate(enrollment.getEnrollmentDate())

                .user(
                        UserDTO.builder()
                                .idUser(enrollment.getUser().getIdUser())
                                .name(enrollment.getUser().getName())
                                .email(enrollment.getUser().getEmail())
                                .role(enrollment.getUser().getRole())
                                .build()
                )

                .course(
                        CourseDTO.builder()
                                .idCourse(enrollment.getCourse().getIdCourse())
                                .title(enrollment.getCourse().getTitle())
                                .description(enrollment.getCourse().getDescription())
                                .price(enrollment.getCourse().getPrice())
                                .build()
                )

                .build();
    }


}

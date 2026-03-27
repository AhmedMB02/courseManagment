package com.school.coursemanagment.services;


import com.school.coursemanagment.DTO.EnrollmentDTO;
import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.exception.AlreadyExistsException;
import com.school.coursemanagment.exception.BadRequestException;
import com.school.coursemanagment.exception.ResourceNotFoundException;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.repository.CourseRepository;
import com.school.coursemanagment.repository.EnrollmentRepository;
import com.school.coursemanagment.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EnrollmentDTO enrollStudent(EnrollmentDTO enrollmentDTO) {

        Long idUser = enrollmentDTO.getUserId();
        System.out.println("--------------User ID = " + enrollmentDTO.getUserId());
        User user = userRepository.findById(idUser).
                orElseThrow( ()-> new ResourceNotFoundException("User not found")
        );

        if(user.getRole()!= Role.student){
            throw new BadRequestException("Only students can enroll in courses");
        }

        Long idCourse = enrollmentDTO.getCourseId();
        System.out.println("--------------Course ID = " + enrollmentDTO.getCourseId());
        Course course = courseRepository.findById(idCourse)
                .orElseThrow(()->new ResourceNotFoundException("Course not found"));

        boolean exist = enrollmentRepository.existsByUserIdUserAndCourseIdCourse(idUser,idCourse);
        if(exist) throw new AlreadyExistsException("Student already enrolled in this course");

        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentDate(
                enrollmentDTO.getEnrollmentDate()!= null ?enrollmentDTO.getEnrollmentDate(): LocalDate.now()
        );
        enrollment.setUser(user);
        enrollment.setCourse(course);

        Enrollment saved = enrollmentRepository.save(enrollment);

        return convertEntityToDto(saved);
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
        return modelMapper.map(enrollmentDTO,Enrollment.class);
    }

    @Override
    public EnrollmentDTO convertEntityToDto(Enrollment enrollment) {
        return modelMapper.map(enrollment,EnrollmentDTO.class);
    }

    // méthode manquante
    /*
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
     */


}

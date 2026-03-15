package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.repository.CourseRepository;
import com.school.coursemanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public CourseDTO saveCourse(Course course) {

        Long idUser = course.getCreator().getIdUser();
        User user = userRepository.getReferenceById(idUser);

        if(!user.getRole().toString().equalsIgnoreCase(String.valueOf(Role.instructor))){
            throw new RuntimeException("Only Instructor can create courses");
        }
        course.setCreator(user);
        return convertEntityToDto( courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Course course) {
        return convertEntityToDto(courseRepository.save(course));
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public CourseDTO getCourseById(Long id) {
        return convertEntityToDto(courseRepository.findById(id).orElse(null));
    }

    @Override
    public CourseDTO convertEntityToDto(Course course) {
       /* CourseDTO courseDTO = new CourseDTO();

        courseDTO.setIdCourse(course.getIdCourse());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCreatedDate(course.getCreatedDate());
        courseDTO.setCreator(course.getCreator());
        courseDTO.setCategory(course.getCategory());
        courseDTO.setEnrollments(course.getEnrollments());
        */
        return CourseDTO.builder()
                .idCourse(course.getIdCourse())
                .title(course.getTitle()).
                description(course.getDescription())
                .price(course.getPrice())
                .createdDate(course.getCreatedDate())
                .category(course.getCategory())
                .creator(course.getCreator())
                .enrollments(course.getEnrollments()).build();
    }
}

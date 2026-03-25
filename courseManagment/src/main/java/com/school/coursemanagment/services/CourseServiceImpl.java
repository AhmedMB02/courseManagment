package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.CourseDTO;
import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.exception.BadRequestException;
import com.school.coursemanagment.exception.ResourceNotFoundException;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.repository.CourseRepository;
import com.school.coursemanagment.repository.UserRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {

        Long idUser = courseDTO.getCreator().getIdUser();

        User user = userRepository.findById(idUser)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));

        if(!user.getRole().toString().equalsIgnoreCase(String.valueOf(Role.instructor))){
            throw new BadRequestException("Only Instructor can create courses");
        }
        Course course = convertDtoToEntity(courseDTO);
        course.setCreator(user);

        return convertEntityToDto( courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        return convertEntityToDto(courseRepository.save(convertDtoToEntity(courseDTO)));
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
        return modelMapper.map(course,CourseDTO.class);
    }

    @Override
    public Course convertDtoToEntity(CourseDTO courseDTO) {
        return modelMapper.map(courseDTO,Course.class);
    }


}

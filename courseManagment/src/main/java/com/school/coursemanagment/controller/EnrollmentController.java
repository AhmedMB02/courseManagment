package com.school.coursemanagment.controller;

import com.school.coursemanagment.DTO.EnrollmentDTO;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public EnrollmentDTO createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentService.enrollStudent(enrollmentDTO);
    }

    @GetMapping("/all")
    public List<EnrollmentDTO> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("student/{id}")
    public List<EnrollmentDTO> getAllEnrollmentsByStudent(@PathVariable Long id){
        return enrollmentService.getEnrollmentsByStudent(id);
    }

    @GetMapping("/all/course/{idCourse}")
    public List<EnrollmentDTO> getEnrollmentsByCourse(@PathVariable Long idCourse){
        return enrollmentService.getEnrollmentsByCourse(idCourse);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
    }

    @GetMapping("/{idenroll}")
    public EnrollmentDTO getEnrollmentById(@PathVariable Long idenroll){
        return enrollmentService.getEnrollmentById(idenroll);
    }
}

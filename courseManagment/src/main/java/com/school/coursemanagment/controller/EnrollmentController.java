package com.school.coursemanagment.controller;

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
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment){
        return enrollmentService.enrollStudent(enrollment);
    }

    @GetMapping("/all")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("student/{id}")
    public List<Enrollment> getAllEnrollmentsByStudent(@PathVariable Long id){
        return enrollmentService.getEnrollmentsByStudent(id);
    }

    @GetMapping("/all/course/{id}")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long idCourse){
        return enrollmentService.getEnrollmentsByCourse(idCourse);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnrollment(@PathVariable Long idEnrollment){
        enrollmentService.deleteEnrollment(idEnrollment);
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long idEnrollment){
        return enrollmentService.getEnrollmentById(idEnrollment);
    }
}

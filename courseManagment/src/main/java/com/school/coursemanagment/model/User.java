package com.school.coursemanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String role;

    private List<Course> courses;

}

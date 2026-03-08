package com.school.coursemanagment.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String email;
    private String role;

    @OneToMany(mappedBy = "")
    private List<Course> courses;

}

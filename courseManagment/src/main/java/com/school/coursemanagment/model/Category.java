package com.school.coursemanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}

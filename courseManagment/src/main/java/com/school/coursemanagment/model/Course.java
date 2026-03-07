package com.school.coursemanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double price ;
    private Date createdDate;

    @ManyToOne
    private Category category;
}

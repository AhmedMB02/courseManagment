package com.school.coursemanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String title;
    private String description;
    private Double price ;
    private Date createdDate;

    @ManyToOne
    private Category category;
}

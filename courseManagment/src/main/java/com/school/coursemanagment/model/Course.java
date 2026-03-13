package com.school.coursemanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "idCategory")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User creator;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Enrollment> enrollments;
}

package com.school.coursemanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.coursemanagment.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;

}

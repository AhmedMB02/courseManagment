package com.school.coursemanagment.DTO;

import com.school.coursemanagment.model.Category;
import com.school.coursemanagment.model.Enrollment;
import com.school.coursemanagment.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //permet de construire des objets complexe facilement
public class CourseDTO {
    private Long idCourse;
    private String title;
    private String description;
    private Double price ;
    private Date createdDate;
    private Category category;
    private User creator;
    private List<Enrollment> enrollments;
}

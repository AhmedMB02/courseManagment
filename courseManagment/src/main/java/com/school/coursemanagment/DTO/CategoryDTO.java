package com.school.coursemanagment.DTO;

import com.school.coursemanagment.model.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long idCategory;
    private String name;
    private String description;
    private List<CourseDTO> courses;
}

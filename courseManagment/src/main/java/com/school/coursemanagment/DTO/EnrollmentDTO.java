package com.school.coursemanagment.DTO;

import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentDTO {
    private Long id;

    private LocalDate enrollmentDate;

    private Long userId;

    private Long courseId;
}

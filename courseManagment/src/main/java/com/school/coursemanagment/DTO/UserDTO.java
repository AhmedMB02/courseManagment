package com.school.coursemanagment.DTO;



import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.Course;
import com.school.coursemanagment.model.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long idUser;
    private String name;
    private String email;
    private Role role;
}

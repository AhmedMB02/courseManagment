package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.UserDTO;
import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.User;

import java.util.List;

public interface UserService {
    UserDTO saveUser(User user);
    UserDTO updateUser(User user);
    void deleteUserById(Long id);
    List<UserDTO>getAllUsers();
    UserDTO getUserById(Long id);
    List<UserDTO> getAllStudent();
    List<UserDTO>getAllInstructor();
    UserDTO convertEntityToDto(User user);
    User convertDtoToEntity(UserDTO userDTO);
}

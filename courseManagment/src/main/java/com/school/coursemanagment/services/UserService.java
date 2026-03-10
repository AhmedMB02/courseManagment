package com.school.coursemanagment.services;

import com.school.coursemanagment.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(Long id);
    List<User>getAllUsers();
    User getUserById(Long id);
}

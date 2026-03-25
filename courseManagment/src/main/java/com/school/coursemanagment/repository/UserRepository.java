package com.school.coursemanagment.repository;


import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByRole(Role role);

    boolean existsByEmail(String email);
}

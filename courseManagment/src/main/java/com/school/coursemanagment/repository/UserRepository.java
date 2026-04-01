package com.school.coursemanagment.repository;


import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByRole(Role role);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(Long aLong);
}

package com.school.coursemanagment.repository;


import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByRole(Role role);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    // Utilisé par UserSecurity.isCourseOwner()
    @Query("SELECT u FROM User u JOIN u.courses c WHERE c.id = :courseId")
    Optional<User> findByCourseId(Long courseId);

    // Utilisé par UserSecurity.isEnrollmentOwner()
    @Query("SELECT u FROM User u JOIN u.enrollments e WHERE e.id = :enrollmentId")
    Optional<User> findByEnrollmentId(Long enrollmentId);
}

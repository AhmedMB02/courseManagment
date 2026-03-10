package com.school.coursemanagment.repository;


import com.school.coursemanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

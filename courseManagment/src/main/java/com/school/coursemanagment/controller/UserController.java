package com.school.coursemanagment.controller;

import com.school.coursemanagment.model.User;
import com.school.coursemanagment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public User createUser(@RequestBody User user){ return userService.saveUser(user);}


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){userService.deleteUserById(id);}

    @GetMapping("/allUsers")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "API works";
    }
}

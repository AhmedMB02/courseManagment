package com.school.coursemanagment.controller;

import com.school.coursemanagment.DTO.UserDTO;
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
    public UserDTO createUser(@RequestBody UserDTO userDTO){ return userService.saveUser(userDTO);}

    @PutMapping("/updateuser/{id}")
    public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        userDTO.setIdUser(id);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){userService.deleteUserById(id);}

    @GetMapping("/allUsers")
    public List<UserDTO>getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/students")
    public List<UserDTO> getAllStudent(){return userService.getAllStudent(); }

    @GetMapping("/instructors")
    public List<UserDTO> getAllInstructor(){return userService.getAllInstructor(); }

}

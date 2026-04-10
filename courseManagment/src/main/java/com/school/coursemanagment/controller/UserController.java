package com.school.coursemanagment.controller;

import com.school.coursemanagment.DTO.UserDTO;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/adduser")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser/{id}")
    public UserDTO updateUser(@PathVariable Long id,@Valid @RequestBody UserDTO userDTO){
        userDTO.setIdUser(id);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){userService.deleteUserById(id);}

    @GetMapping("/allUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO>getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/students")
    @PreAuthorize("hasAnyRole('admin','instructor')")
    public List<UserDTO> getAllStudent(){return userService.getAllStudent(); }

    @GetMapping("/instructors")
    @PreAuthorize("hasAnyRole('admin','instructor')")
    public List<UserDTO> getAllInstructor(){return userService.getAllInstructor(); }


    /*
    @PostMapping("/login")
    public ResponseEntity<?>login(@Valid){

    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(@AuthenticationPrincipal User currentUser){

    }

*/

}

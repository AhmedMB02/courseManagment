package com.school.coursemanagment.services;

import com.school.coursemanagment.DTO.UserDTO;
import com.school.coursemanagment.Enum.Role;
import com.school.coursemanagment.exception.AlreadyExistsException;
import com.school.coursemanagment.model.User;
import com.school.coursemanagment.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            if(userRepository.findByRole(userDTO.getRole()).equals(Role.student)){
                throw new AlreadyExistsException("Student Already exist");
            }else
                throw new AlreadyExistsException("Instructor Already exisit");
        }
        return convertEntityToDto(userRepository.save(convertDtoToEntity(userDTO)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return convertEntityToDto(userRepository.save(convertDtoToEntity(userDTO)));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return convertEntityToDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserDTO> getAllStudent() {

        return userRepository.findByRole(Role.student)
                .stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllInstructor() {
        return  userRepository.findByRole(Role.instructor)
                .stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public UserDTO convertEntityToDto(User user) {
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }

    @Override
    public User convertDtoToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO,User.class );
    }
}

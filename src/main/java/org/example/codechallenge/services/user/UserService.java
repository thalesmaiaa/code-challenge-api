package org.example.codechallenge.services.user;


import org.example.codechallenge.exceptions.NotFoundException;
import org.example.codechallenge.models.department.Department;
import org.example.codechallenge.models.department.DepartmentsType;
import org.example.codechallenge.models.user.User;
import org.example.codechallenge.models.user.UserDTO;
import org.example.codechallenge.repositories.UserRepository;
import org.example.codechallenge.services.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDTOMapper userDTOMapper;

    private final UserRepository userRepository;

    private final DepartmentService departmentService;

    public UserService(UserDTOMapper userDTOMapper, UserRepository userRepository, DepartmentService departmentService) {
        this.userDTOMapper = userDTOMapper;
        this.userRepository = userRepository;
        this.departmentService = departmentService;
    }


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userDTOMapper).collect(Collectors.toList());
    }



    public UserDTO createUser(UserDTO userDTO) {

        Department department = departmentService.findByName(DepartmentsType.valueOf(userDTO.departmentType()));


        User user = new User(
                userDTO.name(),
                userDTO.email(),
                Timestamp.valueOf(LocalDateTime.now()),
                null,
                department.getId()
        );

        User createdUser = userRepository.save(user);
        return userDTOMapper.apply(createdUser);
    }

    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
        return userDTOMapper.apply(user);
    }

    public UserDTO getUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return userDTOMapper.apply(user);
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }

}

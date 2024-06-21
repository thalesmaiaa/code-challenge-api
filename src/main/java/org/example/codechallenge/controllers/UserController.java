package org.example.codechallenge.controllers;


import jakarta.validation.Valid;
import org.example.codechallenge.models.user.UserDTO;
import org.example.codechallenge.services.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable UUID id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@Valid @PathVariable UUID id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }
}

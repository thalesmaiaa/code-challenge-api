package org.example.codechallenge.controllers;

import jakarta.validation.Valid;
import org.example.codechallenge.models.user.UserDTO;
import org.example.codechallenge.services.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserDTO> getAllUsers(@PageableDefault Pageable pageable){
        return userService.findAll(pageable);
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

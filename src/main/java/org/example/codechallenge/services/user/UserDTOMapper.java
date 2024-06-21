package org.example.codechallenge.services;

import org.example.codechallenge.models.user.User;
import org.example.codechallenge.models.user.UserDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartmentId()
        );
    }
}

package org.example.codechallenge.models.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.codechallenge.models.department.DepartmentsType;

import java.util.UUID;

public record UserDTO(
        UUID id,
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email,

        DepartmentsType departmentType
) {
}

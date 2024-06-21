package org.example.codechallenge.models.user;

public record UserDTO(
        java.util.UUID id,
        String name,
        String email
) {
}

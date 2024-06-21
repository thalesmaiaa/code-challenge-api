package org.example.codechallenge.services.user;

import org.example.codechallenge.exceptions.NotFoundException;
import org.example.codechallenge.models.user.User;
import org.example.codechallenge.models.user.UserDTO;
import org.example.codechallenge.repositories.UserRepository;
import org.example.codechallenge.services.department.DepartmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;




@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private  UserService userService;

    @Mock
    private  UserDTOMapper userDTOMapper;

    @Mock
    private  UserRepository userRepository;

    @Mock
    private  DepartmentService departmentService;


    @DisplayName("Should create a user")
    @Test
    void createUser() {
        UUID departmentId = UUID.randomUUID();
        User user = new User(
                UUID.randomUUID(),
                "test",
                "email@email.com",
                Timestamp.valueOf(LocalDateTime.now()),
                null,
                departmentId
        );

        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartmentId()
        );

        when(departmentService.departmentExists(departmentId)).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userDTOMapper.apply(user)).thenReturn(userDTO);

        UserDTO createdUser = userService.createUser(userDTO);

        assertEquals(userDTO.id(), createdUser.id());
        assertEquals(userDTO.name(), createdUser.name());
        assertEquals(userDTO.email(), createdUser.email());
        assertEquals(userDTO.departmentId(), createdUser.departmentId());

        verify(departmentService, times(1)).departmentExists(departmentId);
        verify(userRepository, times(1)).save(any(User.class));
        verify(userDTOMapper, times(1)).apply(user);

    }

    @DisplayName("Should create a user with invalid departmentId")
    @Test
    void testCreateInvalidUser() {
        UUID departmentId = UUID.randomUUID();

        User user = new User(
                UUID.randomUUID(),
                "test",
                "email@email.com",
                Timestamp.valueOf(LocalDateTime.now()),
                null,
                departmentId
        );

        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDepartmentId()
        );

        when(departmentService.departmentExists(departmentId)).thenReturn(false);
        assertThrows(NotFoundException.class,
                () -> userService.createUser(userDTO));

    }

    @DisplayName("Search for invalid users")
    @Test
    void searchUserById(){
        UUID userId = UUID.randomUUID();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.getUser(userId));
        assertThrows(NotFoundException.class, () -> userService.deleteUser(userId));

    }


}
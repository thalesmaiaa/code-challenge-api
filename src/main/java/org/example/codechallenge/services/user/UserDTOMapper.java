package org.example.codechallenge.services.user;

import org.example.codechallenge.models.department.Department;
import org.example.codechallenge.models.department.DepartmentsType;
import org.example.codechallenge.models.user.User;
import org.example.codechallenge.models.user.UserDTO;
import org.example.codechallenge.services.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    private final DepartmentService departmentService;

    public UserDTOMapper(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public UserDTO apply(User user) {

        Department department = departmentService.findDepartmentById(user.getDepartmentId());

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                department.getName()
        );
    }
}

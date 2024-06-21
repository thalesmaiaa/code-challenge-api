package org.example.codechallenge.services.department;

import org.example.codechallenge.exceptions.NotFoundException;
import org.example.codechallenge.models.department.Department;
import org.example.codechallenge.models.department.DepartmentsType;
import org.example.codechallenge.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    public Department findByName(DepartmentsType departmentType) {
        return departmentRepository.findByName(departmentType).orElseThrow(() -> new NotFoundException("Department not found"));
    }

    public Department findDepartmentById(UUID departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("Department not found"));
    }
}



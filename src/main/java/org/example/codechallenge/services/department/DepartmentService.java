package org.example.codechallenge.services.department;

import org.example.codechallenge.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Boolean departmentExists(UUID departmentId) {
        return departmentRepository.findById(departmentId).isPresent();
    }
}



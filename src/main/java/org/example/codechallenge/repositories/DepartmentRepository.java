package org.example.codechallenge.repositories;

import org.example.codechallenge.models.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    Optional<Department> findByName(String departmentType);
}

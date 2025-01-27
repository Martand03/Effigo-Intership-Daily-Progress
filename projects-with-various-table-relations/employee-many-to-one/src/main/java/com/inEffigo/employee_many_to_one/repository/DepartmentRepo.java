package com.inEffigo.employee_many_to_one.repository;

import com.inEffigo.employee_many_to_one.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
//    Optional<Department> findByName(String name);
}

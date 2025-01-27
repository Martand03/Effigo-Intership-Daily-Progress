package com.inEffigo.employee_many_to_one.repository;

import com.inEffigo.employee_many_to_one.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}

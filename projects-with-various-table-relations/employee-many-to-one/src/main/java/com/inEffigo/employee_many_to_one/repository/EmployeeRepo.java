package com.inEffigo.employee_many_to_one.repository;

import com.inEffigo.employee_many_to_one.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
}

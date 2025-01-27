package com.inEffigo.employee_many_to_one.service;

import com.inEffigo.employee_many_to_one.entity.Department;
import com.inEffigo.employee_many_to_one.entity.Employee;
import com.inEffigo.employee_many_to_one.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentService departmentService;

    public Employee saveEmployee(Employee employee, Long departmentId){
        Department department = departmentService.findDepartmentById(departmentId);
        employee.setDepartment(department);
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployeeId(Long id, Employee employeeDetails) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setName(employeeDetails.getName());
        return employeeRepo.save(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepo.deleteById(id);
    }

    public List<Employee> getAllEmployeesByDepartment(String deptName) {
        return employeeRepo.findByDepartmentName(deptName);
    }
}

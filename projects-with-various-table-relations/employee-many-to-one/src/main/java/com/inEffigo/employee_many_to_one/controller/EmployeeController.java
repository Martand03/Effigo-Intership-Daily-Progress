package com.inEffigo.employee_many_to_one.controller;

import com.inEffigo.employee_many_to_one.entity.Employee;
import com.inEffigo.employee_many_to_one.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee, @RequestParam Long departmentId){
        return employeeService.saveEmployee(employee, departmentId);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployeeId(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/{departmentName}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String departmentName){
        return employeeService.getAllEmployeesByDepartment(departmentName);
    }
}

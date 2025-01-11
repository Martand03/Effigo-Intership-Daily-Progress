package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3360)
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PatchMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId) {
        Employee empObj = employeeService.getEmployeeById(employeeId);
        if (empObj != null) {
            empObj.setManager(employee.getManager());
            empObj.setName(employee.getName());
            empObj.setSalary(employee.getSalary());
        }
        return ResponseEntity.ok(employeeService.updateEmployee(empObj));
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable("employeeId") Long employeeId) {

        Employee empObj = employeeService.getEmployeeById(employeeId);
        String deleteMsg = null;
        if (empObj != null) {
            deleteMsg = employeeService.deleteEmployee(empObj);
        }
        return ResponseEntity.ok(deleteMsg);
    }
}

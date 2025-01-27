package com.inEffigo.employee_many_to_one.controller;

import com.inEffigo.employee_many_to_one.entity.Department;
import com.inEffigo.employee_many_to_one.entity.Employee;
import com.inEffigo.employee_many_to_one.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartmentById(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
    }

}

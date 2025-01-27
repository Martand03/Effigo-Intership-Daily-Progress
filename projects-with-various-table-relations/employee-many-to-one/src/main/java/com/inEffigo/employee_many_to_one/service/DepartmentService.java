package com.inEffigo.employee_many_to_one.service;

import com.inEffigo.employee_many_to_one.entity.Department;
import com.inEffigo.employee_many_to_one.entity.Employee;
import com.inEffigo.employee_many_to_one.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public Department findDepartmentById(Long id){
        return departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }



    public Department updateDepartmentById(Long id, Department updatedDepartment) {
        Department existingDepartment = findDepartmentById(id);
        existingDepartment.setName(updatedDepartment.getName());
        return departmentRepo.save(existingDepartment);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepo.deleteById(id);
    }
}

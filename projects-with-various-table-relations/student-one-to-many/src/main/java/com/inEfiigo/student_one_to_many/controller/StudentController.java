package com.inEfiigo.student_one_to_many.controller;

import com.inEfiigo.student_one_to_many.entities.StudentCourses;
import com.inEfiigo.student_one_to_many.entities.StudentDetails;
import com.inEfiigo.student_one_to_many.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<StudentDetails> listAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public StudentDetails addStudent(@RequestBody StudentDetails studentDetails){
        return studentService.saveStudent(studentDetails);
    }
}

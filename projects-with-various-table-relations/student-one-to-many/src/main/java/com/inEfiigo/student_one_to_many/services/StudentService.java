package com.inEfiigo.student_one_to_many.services;

import com.inEfiigo.student_one_to_many.entities.StudentDetails;
import com.inEfiigo.student_one_to_many.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDetails saveStudent(StudentDetails studentDetails){
        return studentRepository.save(studentDetails);
    }

    public List<StudentDetails> getAllStudents(){
        return studentRepository.findAll();
    }
}

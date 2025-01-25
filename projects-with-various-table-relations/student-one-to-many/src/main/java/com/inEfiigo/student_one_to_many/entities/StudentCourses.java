package com.inEfiigo.student_one_to_many.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(schema = "student_db")
public class StudentCourses {
    @Id
    @GeneratedValue
    private Long id;

    private String courseName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentDetails student;

    public StudentCourses(){

    }

    public StudentCourses(Long id, String courseName, StudentDetails student) {
        this.id = id;
        this.courseName = courseName;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public StudentDetails getStudent() {
        return student;
    }

    public void setStudent(StudentDetails student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentCourses{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", studentDetails=" + student +
                '}';
    }
}

package com.inEfiigo.student_one_to_many.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "student_db")
public class StudentDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StudentCourses> courses = new ArrayList<>();

    public StudentDetails(){

    }

    public StudentDetails(Long id, String name, String email, List<StudentCourses> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<StudentCourses> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourses> courses) {
        this.courses = courses;
    }

    public void addCourse(StudentCourses course) {
        courses.add(course);
        course.setStudent(this);
    }

    public void removeCourse(StudentCourses course) {
        courses.remove(course);
        course.setStudent(null);
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}

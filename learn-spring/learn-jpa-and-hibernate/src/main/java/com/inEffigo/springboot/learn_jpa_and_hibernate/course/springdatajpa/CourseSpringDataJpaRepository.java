package com.inEffigo.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import com.inEffigo.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<name of what entity it manages, id field datatype>
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

}

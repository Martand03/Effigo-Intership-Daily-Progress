package com.inEffigo.ols_backend_spring.coursematerial.repository;

import com.inEffigo.ols_backend_spring.coursematerial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

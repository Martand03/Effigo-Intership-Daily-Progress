package com.inEffigo.multi_table_project.repository;

import com.inEffigo.multi_table_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

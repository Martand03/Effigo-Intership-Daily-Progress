package com.inEfiigo.student_one_to_many.repositories;

import com.inEfiigo.student_one_to_many.entities.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<StudentCourses, Long> {
}

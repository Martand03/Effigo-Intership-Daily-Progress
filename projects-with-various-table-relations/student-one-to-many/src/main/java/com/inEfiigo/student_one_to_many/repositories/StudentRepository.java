package com.inEfiigo.student_one_to_many.repositories;

import com.inEfiigo.student_one_to_many.entities.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
}

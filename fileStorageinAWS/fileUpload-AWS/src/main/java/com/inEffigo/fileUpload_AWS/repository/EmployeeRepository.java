package com.inEffigo.fileUpload_AWS.repository;

import com.inEffigo.fileUpload_AWS.entity.EmployeeAWS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeAWS, Long> {
}

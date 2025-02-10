package com.inEffigo.ols_backend_spring.coursematerial.repository;

import com.inEffigo.ols_backend_spring.coursematerial.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

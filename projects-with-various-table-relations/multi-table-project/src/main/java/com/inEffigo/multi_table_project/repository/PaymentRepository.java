package com.inEffigo.multi_table_project.repository;

import com.inEffigo.multi_table_project.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

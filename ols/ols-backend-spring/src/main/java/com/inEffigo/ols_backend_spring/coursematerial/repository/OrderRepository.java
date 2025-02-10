package com.inEffigo.ols_backend_spring.coursematerial.repository;

import com.inEffigo.ols_backend_spring.coursematerial.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

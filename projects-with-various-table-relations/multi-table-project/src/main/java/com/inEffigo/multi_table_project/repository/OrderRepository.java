package com.inEffigo.multi_table_project.repository;

import com.inEffigo.multi_table_project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

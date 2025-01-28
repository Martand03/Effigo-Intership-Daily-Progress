package com.inEffigo.customer_many_to_many.repository;

import com.inEffigo.customer_many_to_many.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}

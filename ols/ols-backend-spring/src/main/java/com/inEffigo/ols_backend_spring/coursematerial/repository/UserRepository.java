package com.inEffigo.ols_backend_spring.coursematerial.repository;

import com.inEffigo.ols_backend_spring.coursematerial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}

package com.inEffigo.spring_microservice_L2.repository;

import com.inEffigo.spring_microservice_L2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

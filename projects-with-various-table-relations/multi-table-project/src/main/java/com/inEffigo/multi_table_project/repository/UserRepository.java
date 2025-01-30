package com.inEffigo.multi_table_project.repository;

import com.inEffigo.multi_table_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

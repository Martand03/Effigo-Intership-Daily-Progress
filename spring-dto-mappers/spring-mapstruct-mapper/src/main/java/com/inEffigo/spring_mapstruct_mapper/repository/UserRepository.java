package com.inEffigo.spring_mapstruct_mapper.repository;

import com.inEffigo.spring_mapstruct_mapper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

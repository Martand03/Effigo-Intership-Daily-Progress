package com.inEffigo.spring_security_jwt_db.repository;

import com.inEffigo.spring_security_jwt_db.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUsername(String username);
}

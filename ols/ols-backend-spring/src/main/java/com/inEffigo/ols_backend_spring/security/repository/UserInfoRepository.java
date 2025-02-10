package com.inEffigo.ols_backend_spring.security.repository;

import com.inEffigo.ols_backend_spring.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username);
}

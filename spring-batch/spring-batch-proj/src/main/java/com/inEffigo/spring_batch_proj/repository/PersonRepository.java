package com.inEffigo.spring_batch_proj.repository;

import com.inEffigo.spring_batch_proj.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

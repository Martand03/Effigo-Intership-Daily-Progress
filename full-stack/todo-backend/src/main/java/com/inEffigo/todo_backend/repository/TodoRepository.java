package com.inEffigo.todo_backend.repository;

import com.inEffigo.todo_backend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUsername(String username);
}

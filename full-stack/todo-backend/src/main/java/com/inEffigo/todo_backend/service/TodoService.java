package com.inEffigo.todo_backend.service;

import com.inEffigo.todo_backend.entity.Todo;
import com.inEffigo.todo_backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    private Todo todos;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> findByUsername(String username){
        return todoRepository.findByUsername(username);
    }

    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }

    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    public void addTodo(String username,Todo todo) {
        todo.setUsername(username);
        todoRepository.save(todo);
    }
}

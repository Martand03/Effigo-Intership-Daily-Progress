package com.inEffigo.todo_backend.controller;
import com.inEffigo.todo_backend.entity.Todo;
import com.inEffigo.todo_backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> listAllTodo(){
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public String addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
        return "Todo added";
    }

    @GetMapping("/todos/{username}")
    public List<Todo> getTodoByUsername(@PathVariable String username){
        return todoService.findByUsername(username);
    }

    @GetMapping("/todos/{username}/{id}")
    public Optional<Todo> getTodoByUsernameId(@PathVariable String username, @PathVariable Long id){
        return todoService.findById(id);
    }

    @DeleteMapping("/todos/delete/{username}/{id}")
    public void deleteUserById(@PathVariable Long id){
        todoService.deleteById(id);
    }

    @PutMapping("/todos/{username}/{id}")
    public Todo updateTodoDetails(@PathVariable String username, @PathVariable Long id, @RequestBody Todo todo){
        todo.setId(id);
        todo.setUsername(username);
        return  todoService.updateTodo(todo);
    }

    @PostMapping("/todos/{username}")
    public void createTodoDetails(@PathVariable String username, @RequestBody Todo todo){
        todoService.addTodo(username, todo);
    }
}

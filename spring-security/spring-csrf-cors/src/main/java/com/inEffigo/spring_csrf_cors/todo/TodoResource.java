package com.inEffigo.spring_csrf_cors.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private static List<Todo> TODO_LIST = List.of(
            new Todo("inEffigo", "AWS1"),
            new Todo("inEffigo", "GCP1")
    );

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo getTodoForUser(@PathVariable String username){
        return TODO_LIST.get(0);
    }

    @PostMapping("/todos")
    public void createTodo(@RequestBody Todo todo){

    }

}

record Todo (String username, String description){

};
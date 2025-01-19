package com.inEffigo.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

    private static List<Todo> todos;
    static{
        todos.add(new Todo(1, "inEffigo", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "inEffigo", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "inEffigo", "Learn AIML",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}

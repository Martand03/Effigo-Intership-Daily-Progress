package com.inEffigo.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos;
    private static int todosCount = 0;
    static{
        todos = new ArrayList<>();
        todos.add(new Todo(++todosCount, "inEffigo", "Learn AWS inEffigo",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "inEffigo", "Learn DevOps inEffigo",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "inEffigo", "Learn AIML inEffigo",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo ->todo.getUsername().equals(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username, description,targetDate, done);
        todos.add(todo);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo ->todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo ->todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateById(Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

}

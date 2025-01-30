package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.User;
import com.inEffigo.multi_table_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }
}

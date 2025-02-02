package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.User;
import com.inEffigo.multi_table_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> getUserById(Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/enroll/{courseId}")
    public ResponseEntity<User> enrollUserInCourse(@PathVariable Long userId, @PathVariable Long courseId){
        User updatedUser = userService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{userId}/email")
    public ResponseEntity<User> updateUserEmail(@PathVariable Long userId, @RequestParam String userNewEmail){
        userService.updateUserEmail(userId, userNewEmail);
        return ResponseEntity.ok().build();
    }

}

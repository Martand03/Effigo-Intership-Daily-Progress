package com.inEffigo.multi_table_project.service;

import com.inEffigo.multi_table_project.entity.Course;
import com.inEffigo.multi_table_project.entity.User;
import com.inEffigo.multi_table_project.repository.CourseRepository;
import com.inEffigo.multi_table_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // get all users list
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // get user by its user id
    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found by Id"));
    }

    //create a user
    public User createUser(User user){
        return userRepository.save(user);
    }

    // delete a user by id
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    // assign course to user
    public User enrollUserInCourse(Long userId, Long courseId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if(userOptional.isPresent() && courseOptional.isPresent() ){
            User user = userOptional.get();
            Course course = courseOptional.get();
            user.getCourses().add(course);
            return userRepository.save(user);
        }else{
            throw new RuntimeException("User or Course not found check the id");
        }
    }

}

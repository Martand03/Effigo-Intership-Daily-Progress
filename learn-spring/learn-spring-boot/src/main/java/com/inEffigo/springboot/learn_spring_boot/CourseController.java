package com.inEffigo.springboot.learn_spring_boot;

// to access this: /course
// what to display: Course: id, name, author


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn AWS", "inEffigo"),
                new Course(2, "Learn Devops", "inHyd"),
                new Course(3, "Spring", "inHydOffice")
        );
    }

}

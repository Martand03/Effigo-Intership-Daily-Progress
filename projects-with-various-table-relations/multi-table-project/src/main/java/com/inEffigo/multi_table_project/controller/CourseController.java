package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.Course;
import com.inEffigo.multi_table_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId){
        Course course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse,HttpStatus.CREATED);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/assign/{catId}")
    public ResponseEntity<Course> assignCourseInCategory(@PathVariable Long courseId, @PathVariable Long catId){
        Course updatedCourse = courseService.addCourseToCategory(courseId, catId);
        return ResponseEntity.ok(updatedCourse);
    }

    // update course price
    @PatchMapping("/{courseId}/price")
    public ResponseEntity<Void> updateCoursePrice(@PathVariable Long courseId, @RequestParam Double newPrice){
        courseService.updateCoursePrice(courseId, newPrice);
        return ResponseEntity.ok().build();
    }
}

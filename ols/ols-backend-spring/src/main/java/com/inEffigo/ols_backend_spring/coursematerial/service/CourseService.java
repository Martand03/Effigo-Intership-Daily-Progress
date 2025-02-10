package com.inEffigo.ols_backend_spring.coursematerial.service;

import com.inEffigo.ols_backend_spring.coursematerial.entity.Category;
import com.inEffigo.ols_backend_spring.coursematerial.entity.Course;
import com.inEffigo.ols_backend_spring.coursematerial.entity.User;
import com.inEffigo.ols_backend_spring.coursematerial.repository.CategoryRepository;
import com.inEffigo.ols_backend_spring.coursematerial.repository.CourseRepository;
import com.inEffigo.ols_backend_spring.coursematerial.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    // get all courses
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // get a course by its id
    public Course getCourseById(Long courseId){
        return courseRepository.findById(courseId)
                .orElseThrow(()->new RuntimeException("Course not found by id"));
    }

    // create a course
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    // delete a course by id
    @Transactional
    public void deleteCourseById(Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        for (User user : course.getUsers()) {
            user.getCourses().remove(course);
        }
        userRepository.saveAll(course.getUsers());
        courseRepository.deleteById(courseId);
    }

    // assign course to a category
    public Course addCourseToCategory(Long courseId, Long categoryId){
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if(courseOptional.isPresent() && categoryOptional.isPresent()){
            Course course = courseOptional.get();
            course.setCategory(categoryOptional.get());
            return courseRepository.save(course);
        }else{
            throw new RuntimeException("Course or category not found check id's");
        }
    }

    // update course price
    public void updateCoursePrice(Long courseId, Double newPrice){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()->new RuntimeException("Course not found"));
        course.setCoursePrice(newPrice);
        courseRepository.save(course);
    }
}

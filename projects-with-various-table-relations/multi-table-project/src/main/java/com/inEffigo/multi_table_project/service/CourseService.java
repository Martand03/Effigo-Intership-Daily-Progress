package com.inEffigo.multi_table_project.service;

import com.inEffigo.multi_table_project.entity.Category;
import com.inEffigo.multi_table_project.entity.Course;
import com.inEffigo.multi_table_project.repository.CategoryRepository;
import com.inEffigo.multi_table_project.repository.CourseRepository;
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
    public void deleteCourseById(Long courseId){
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
}

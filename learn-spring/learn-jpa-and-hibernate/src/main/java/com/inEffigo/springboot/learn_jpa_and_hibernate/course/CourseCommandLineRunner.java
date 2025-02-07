package com.inEffigo.springboot.learn_jpa_and_hibernate.course;


import com.inEffigo.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.inEffigo.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.inEffigo.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // for using jdbc
//    @Autowired
//    private CourseJdbcRepository repository;

    // for using jpa
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // for spring-jdbc and jpa
//        repository.insert(new Course(1,"LearnAWS", "inEffigo"));
//        repository.insert(new Course(2,"LearnDevops", "inEffigo"));
//        repository.insert(new Course(3,"LearnAzure", "inEffigo"));
//        repository.deleteById(2);
//        System.out.println(repository.findById(3));


        // for spring-jpa
        repository.save(new Course(1,"LearnAWS", "inEffigo"));
        repository.save(new Course(2,"LearnDevops", "inEffigo"));
        repository.save(new Course(3,"LearnAzure", "inEffigo"));
        repository.deleteById(2L);
        System.out.println(repository.findById(3L));
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByAuthor("inEffigo"));
    }
}

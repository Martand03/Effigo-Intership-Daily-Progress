package com.inEffigo.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// if using jpa then we use the annotations like @Entity, @Column, @Id, etc. not in jdbc

@Entity   // if you want to do it with different table name then @Entity(name="table_name")
public class Course {

    @Id   //to make it primary key
    private long id;

//    @Column(name="name") not needed now because column name is same as the name of variable used
    private String name;
//    @Column(name="author") same goes here
    private String author;

    public Course(){

    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

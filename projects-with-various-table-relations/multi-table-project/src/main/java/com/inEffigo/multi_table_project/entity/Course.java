package com.inEffigo.multi_table_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "multi_table_proj")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long courseId;

    private String courseName;
    private String courseDescription;
    private Double coursePrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("courses")
    private Category category;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();
}

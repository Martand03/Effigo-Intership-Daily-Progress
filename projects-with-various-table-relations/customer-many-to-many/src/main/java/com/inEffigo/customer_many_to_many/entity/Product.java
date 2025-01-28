package com.inEffigo.customer_many_to_many.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "customer_db")
//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "products", cascade=CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();

}

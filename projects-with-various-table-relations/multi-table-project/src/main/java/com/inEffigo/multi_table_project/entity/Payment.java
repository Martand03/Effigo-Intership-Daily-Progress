package com.inEffigo.multi_table_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "multi_table_proj")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private Long payId;

    private String payMethod;
    private Double payAmount;
    private String payStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

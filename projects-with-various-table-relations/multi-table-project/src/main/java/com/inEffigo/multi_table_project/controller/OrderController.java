package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.Order;
import com.inEffigo.multi_table_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order orderData){
        return orderService.createOrder(orderData);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/createOrder/{courseId}")
    public ResponseEntity<Order> createOrderForUser(@PathVariable Long userId, @PathVariable Long courseId, @RequestParam String orderStatus){
        Order createdOrder = orderService.createOrderForUser(userId, courseId, orderStatus);
        return ResponseEntity.ok(createdOrder);
    }
}

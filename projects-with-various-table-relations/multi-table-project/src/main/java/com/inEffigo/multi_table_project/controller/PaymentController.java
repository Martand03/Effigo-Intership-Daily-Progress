package com.inEffigo.multi_table_project.controller;

import com.inEffigo.multi_table_project.entity.Payment;
import com.inEffigo.multi_table_project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{payId}")
    public Payment getPaymentById(@PathVariable Long payId){
        return paymentService.getPaymentById(payId);
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment payment1 = paymentService.createPayment(payment);
        return ResponseEntity.ok(payment1);
    }

    @DeleteMapping("/{payId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long payId){
        paymentService.deletePayment(payId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(@RequestParam Long orderId, @RequestParam String payMethod, @RequestParam String payStatus){
        Payment createdPayment = paymentService.processPayment(orderId, payMethod, payStatus);
        return ResponseEntity.ok(createdPayment);
    }
}

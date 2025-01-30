package com.inEffigo.multi_table_project.service;

import com.inEffigo.multi_table_project.entity.Order;
import com.inEffigo.multi_table_project.entity.Payment;
import com.inEffigo.multi_table_project.repository.OrderRepository;
import com.inEffigo.multi_table_project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long payId) {
        return paymentRepository.findById(payId)
                .orElseThrow(()-> new RuntimeException("Payment not found by id"));
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long payId) {
        paymentRepository.deleteById(payId);
    }

    // process a payment for a order
    public Payment processPayment(Long orderId, String payMethod, String paymentStatus){
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if(orderOptional.isPresent()){
            Order order = orderOptional.get();

            Payment payment = new Payment();
            payment.setOrder(order);
            payment.setPayMethod(payMethod);
            payment.setPayAmount(order.getOrderTotalAmount());
            payment.setPayStatus(paymentStatus);

            order.setOrderStatus("PAID");
            orderRepository.save(order);

            return paymentRepository.save(payment);
        }else{
            throw new RuntimeException("Oder not found by id");
        }
    }
}

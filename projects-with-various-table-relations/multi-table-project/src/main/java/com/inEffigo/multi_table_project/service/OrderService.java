package com.inEffigo.multi_table_project.service;

import com.inEffigo.multi_table_project.entity.Course;
import com.inEffigo.multi_table_project.entity.Order;
import com.inEffigo.multi_table_project.entity.User;
import com.inEffigo.multi_table_project.repository.CourseRepository;
import com.inEffigo.multi_table_project.repository.OrderRepository;
import com.inEffigo.multi_table_project.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Oder not found by id"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    // creating an order for user who purchases a course
    public Order createOrderForUser(Long userId, Long courseId, String orderStatus){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if(userOptional.isPresent() && courseOptional.isPresent()){
            User user = userOptional.get();
            Course course = courseOptional.get();

            Order order = new Order();
            order.setUser(user);
            order.setCourse(course);
            order.setOrderStatus(orderStatus);
            order.setOrderTotalAmount(course.getCoursePrice());

            return orderRepository.save(order);
        }else {
            throw new RuntimeException("User or course not found by id's");
        }
    }
}

package com.inEffigo.customer_many_to_many.service;

import com.inEffigo.customer_many_to_many.entity.Customer;
import com.inEffigo.customer_many_to_many.entity.Product;
import com.inEffigo.customer_many_to_many.repository.CustomerRepo;
import com.inEffigo.customer_many_to_many.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepo.findById(id);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer addProductToCustomer(Long customerId, Long productId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        customer.getProducts().add(product);
        product.getCustomers().add(customer);

        productRepo.save(product);
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        Customer customer1 = getCustomerById(customer.getId()).orElseThrow(()-> new RuntimeException("Customer not foung"));
        customer1.setName(customer.getName());
        return customerRepo.save(customer1);
    }

    public void deleteCustomerById(Long id){
        customerRepo.deleteById(id);
    }
}

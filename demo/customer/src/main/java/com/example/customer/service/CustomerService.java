package com.example.customer.service;

import com.example.customer.repo.CustomerRepo;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepo customerRepo) {
    public void registerCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO：检查邮箱合法性、唯一性
        customerRepo.save(customer);
    }
}

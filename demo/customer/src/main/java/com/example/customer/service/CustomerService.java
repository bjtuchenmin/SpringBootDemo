package com.example.customer.service;

import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.customer.repo.CustomerRepo;
import com.example.customer.model.Customer;
import com.example.customer.model.CustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{
    private final RestTemplate restTemplate;
    private final CustomerRepo customerRepo;
    private FraudClient fraudClient;
    public void registerCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO：检查邮箱合法性、唯一性
        customerRepo.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudulentCustomer()) {
            throw new IllegalArgumentException("It is checked fraud");
        }
        // TODO: send notification
    }
}

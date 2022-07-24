package com.example.customer.service;

import com.example.customer.model.FraudCheckResponse;
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
    public void registerCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO：检查邮箱合法性、唯一性
        customerRepo.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        if (fraudCheckResponse.isFraudulentCustomer()) {
            throw new IllegalArgumentException("It is checked fraud");
        }
        // TODO: send notification
    }
}

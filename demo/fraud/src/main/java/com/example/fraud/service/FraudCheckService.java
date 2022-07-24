package com.example.fraud.service;

import com.example.fraud.model.FraudCheckHistory;
import com.example.fraud.repo.FraudCheckHistoryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

    public FraudCheckService(FraudCheckHistoryRepo fraudCheckHistoryRepo) {
        this.fraudCheckHistoryRepo = fraudCheckHistoryRepo;
    }

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepo.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}

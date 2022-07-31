package com.example.notification.service;

import com.example.notification.rabbitMQ.MessageTemplate;
import com.example.notification.repo.NotificationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepo;

    public void store(MessageTemplate messageTemplate) {
        notificationRepo.save(messageTemplate);
    }
}

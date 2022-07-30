package com.example.notification.service;

import com.example.notification.model.Notification;
import com.example.notification.repo.NotificationRepo;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepo notificationRepo;

    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public void send(Notification notification) {
        notificationRepo.save(notification);
    }
}

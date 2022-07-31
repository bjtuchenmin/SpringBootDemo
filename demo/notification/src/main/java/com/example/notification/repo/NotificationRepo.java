package com.example.notification.repo;

import com.example.notification.rabbitMQ.MessageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<MessageTemplate, Integer> {
}

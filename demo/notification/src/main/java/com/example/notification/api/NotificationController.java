package com.example.notification.api;

import com.example.notification.model.Notification;
import com.example.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("api/v1/send-notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(path = "{message}")
    public void sendNotification(@PathVariable("message") String message) {
        log.info("----------- Send notification -----------");
        Notification notification = Notification.builder()
                .message(message)
                .createAt(LocalDateTime.now())
                .build();
        notificationService.send(notification);
    }
}

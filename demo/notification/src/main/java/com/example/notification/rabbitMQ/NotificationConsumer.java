package com.example.notification.rabbitMQ;

import com.example.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(MessageTemplate messageTemplate) {
        log.info("--- Consumed {} from queue ---", messageTemplate);
        notificationService.store(messageTemplate);
    }
}

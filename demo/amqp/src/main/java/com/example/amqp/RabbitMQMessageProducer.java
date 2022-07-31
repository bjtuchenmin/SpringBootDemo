package com.example.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    /**
     * 发布消息
     * @param exchange 生产者将消息发布到 exchange
     * @param routingKey exchange 根据 routingKey 决定消息发布到队列中的方式
     * @param payload 消息，Object 类型
     */
    public void publish(String exchange, String routingKey, Object payload) {
        log.info("--- Publishing to {} using routing key {}. Payload: {} ---", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("--- Published ---");
    }
}

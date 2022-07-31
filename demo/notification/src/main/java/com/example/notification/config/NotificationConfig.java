package com.example.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置消息队列所需的 exchange, binging, routing key
 */
@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    /**
     * producer 将消息传入 exchange, 再由 exchange 将消息传入队列
     * @return
     */
    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    /**
     * 选择消息要传入的队列
     * @return
     */
    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }

    /**
     * exchange 与队列的绑定（连接器）
     * @return
     */
    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(this.notificationQueue())
                .to(this.internalTopicExchange())
                .with(this.internalNotificationRoutingKey);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}

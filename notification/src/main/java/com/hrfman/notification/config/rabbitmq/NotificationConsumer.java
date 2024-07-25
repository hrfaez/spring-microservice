package com.hrfman.notification.config.rabbitmq;

import com.hrfman.clients.notification.NotificationRequest;
import com.hrfman.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;
    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Consumed {} from queue",notificationRequest);
        notificationService.send(notificationRequest);
    }
}

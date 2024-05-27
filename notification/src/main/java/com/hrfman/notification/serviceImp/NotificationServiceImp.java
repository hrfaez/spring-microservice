package com.hrfman.notification.serviceImp;

import com.hrfman.clients.notification.NotificationRequest;
import com.hrfman.notification.model.Notification;
import com.hrfman.notification.repository.NotificationRepository;
import com.hrfman.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationServiceImp implements NotificationService {
    private final NotificationRepository notificationRepository;
    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.customerId())
                        .toCustomerEmail(notificationRequest.customerEmail())
                        .sender("Amigoscode")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}

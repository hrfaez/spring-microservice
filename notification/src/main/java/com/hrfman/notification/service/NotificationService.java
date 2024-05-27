package com.hrfman.notification.service;

import com.hrfman.clients.notification.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}

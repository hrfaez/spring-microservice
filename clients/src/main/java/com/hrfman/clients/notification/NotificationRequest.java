package com.hrfman.clients.notification;

public record NotificationRequest(
        Integer customerId,
        String customerEmail,
        String message
) {
}

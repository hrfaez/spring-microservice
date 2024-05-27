package com.hrfman.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    @CreationTimestamp
    private LocalDateTime sentAt;
}

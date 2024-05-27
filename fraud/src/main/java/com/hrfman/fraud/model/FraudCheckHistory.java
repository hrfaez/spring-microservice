package com.hrfman.fraud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_id_sequnce",
            sequenceName = "fraud_id_sequnce",
            initialValue = 10,
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "fraud_id_sequnce",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private Integer customerId;

    private Boolean isFraudster;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;
}

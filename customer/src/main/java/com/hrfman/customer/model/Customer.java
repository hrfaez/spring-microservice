package com.hrfman.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            initialValue = 10,
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
}

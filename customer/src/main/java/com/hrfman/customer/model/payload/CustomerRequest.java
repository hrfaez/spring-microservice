package com.hrfman.customer.model.payload;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email
) {
}

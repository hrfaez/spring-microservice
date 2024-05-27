package com.hrfman.customer.service;

import com.hrfman.customer.model.payload.CustomerRequest;

public interface CustomerService {
    void registerCustomer(CustomerRequest customerRequest);
}

package com.hrfman.customer.controller;

import com.hrfman.customer.model.payload.CustomerRequest;
import com.hrfman.customer.serviceImpl.CustomerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerServiceImp customerServiceImp) {
    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRequest customerRequest
    ){
        log.info("new customer registration {}",customerRequest);
        customerServiceImp.registerCustomer(customerRequest);
    }
}

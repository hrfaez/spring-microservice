package com.hrfman.customer.serviceImpl;

import com.hrfman.customer.model.Customer;
import com.hrfman.customer.model.customerPayload.FraudCheckResponse;
import com.hrfman.customer.model.payload.CustomerRequest;
import com.hrfman.customer.repository.CustomerRepository;
import com.hrfman.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    @Override
    public void registerCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }
}

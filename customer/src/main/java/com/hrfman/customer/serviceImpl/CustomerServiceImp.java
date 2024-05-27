package com.hrfman.customer.serviceImpl;

import com.hrfman.clients.fraud.FraudCheckResponse;
import com.hrfman.clients.fraud.FraudClient;
import com.hrfman.clients.notification.NotificationClient;
import com.hrfman.clients.notification.NotificationRequest;
import com.hrfman.customer.model.Customer;
import com.hrfman.customer.model.payload.CustomerRequest;
import com.hrfman.customer.repository.CustomerRepository;
import com.hrfman.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    @Override
    public void registerCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("HI %s, welcome", customer.getFirstName())
                )
        );
    }
}

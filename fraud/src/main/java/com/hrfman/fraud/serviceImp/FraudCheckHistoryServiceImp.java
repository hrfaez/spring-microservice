package com.hrfman.fraud.serviceImp;

import com.hrfman.fraud.model.FraudCheckHistory;
import com.hrfman.fraud.repository.FraudCheckHistoryRepository;
import com.hrfman.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryServiceImp implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Override
    public boolean isFraudulentCustomer(Integer customerID) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerID)
                .isFraudster(false)
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}

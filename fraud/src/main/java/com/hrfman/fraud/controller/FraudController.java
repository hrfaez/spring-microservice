package com.hrfman.fraud.controller;

import com.hrfman.clients.fraud.FraudCheckResponse;
import com.hrfman.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId
    ){
        log.info("FraudController - isFraudster - customerId : {}", customerId);
        boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}

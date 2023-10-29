package com.bayu.controller;

import com.bayu.clients.fraud.FraudCheckResponse;
import com.bayu.clients.fraud.FraudRequest;
import com.bayu.dto.FraudCheckResponse;
import com.bayu.dto.FraudRequest;
import com.bayu.service.FraudCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/fraud-checks")
@Slf4j
public record FraudController(FraudCustomerService fraudCustomerService) {

    @PostMapping()
    public FraudCheckResponse checkFraudCustomer(@RequestBody FraudRequest fraudRequest) {
        log.info("Intercept check customer fraud {}", fraudRequest);

        boolean fraud = fraudCustomerService.checkingCustomerInfo(fraudRequest);

        return new FraudCheckResponse(fraud);
    }

}

package com.bayu.customer.controller;

import com.bayu.customer.dto.CustomerRegistrationRequest;
import com.bayu.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerNewCustomer(@RequestBody CustomerRegistrationRequest registrationRequest) {
        log.info("Intercept request register new customer {}", registrationRequest);
        customerService.registerCustomer(registrationRequest);
    }

}

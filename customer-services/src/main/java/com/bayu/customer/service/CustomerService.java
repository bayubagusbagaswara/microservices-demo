package com.bayu.customer.service;

import com.bayu.customer.dto.CustomerRegistrationRequest;
import com.bayu.customer.model.Customer;
import com.bayu.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest registrationRequest) {
        Customer customer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .gender(registrationRequest.gender())
                .email(registrationRequest.email())
                .phoneNumber(registrationRequest.phoneNumber())
                .idType(registrationRequest.idType())
                .idValue(registrationRequest.idValue())
                .createdAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer);
        log.info("Customer info {}", customer);
    }

}

package com.bayu.customer.service;

import com.bayu.clients.fraud.FraudCheckResponse;
import com.bayu.clients.fraud.FraudRequest;
import com.bayu.customer.dto.CustomerRegistrationRequest;
import com.bayu.customer.model.Customer;
import com.bayu.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

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

        FraudRequest fraudRequest = new FraudRequest(
                registrationRequest.idType(),
                registrationRequest.idValue()
        );

        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse();

        // request checking customer fraud via RestTemplate
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper objectMapper = new ObjectMapper();

            String fraudJsonRequest = objectMapper.writeValueAsString(fraudRequest);
            HttpEntity<Object> httpEntity = new HttpEntity<>(fraudJsonRequest, httpHeaders);

            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    "http://localhost:8081/api/v1/fraud-checks",
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );

            fraudCheckResponse = objectMapper.readValue(responseEntity.getBody(), FraudCheckResponse.class);

        } catch (Exception exception) {
            log.error(exception.getLocalizedMessage());
        }

        if (null != fraudCheckResponse)

        // customerRepository.save(customer);
        log.info("Customer info {}", customer);
    }

}

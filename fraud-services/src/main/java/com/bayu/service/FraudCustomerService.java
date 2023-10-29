package com.bayu.service;

import com.bayu.clients.fraud.FraudRequest;
import com.bayu.dto.FraudRequest;
import com.bayu.model.FraudCustomer;
import com.bayu.repository.FraudCustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public record FraudCustomerService(FraudCustomerRepository fraudCustomerRepository) {

    public boolean checkingCustomerInfo(FraudRequest fraudRequest) {

        String idType = fraudRequest.idType();
        String idValue = fraudRequest.idValue();

        Optional<FraudCustomer> fraudCustomer = fraudCustomerRepository
                .findAllByIdTypeAndIdValue(idType, idValue);

        if (fraudCustomer.isPresent()) {
            log.warn("Customer info with id type {} and id value {} already exists",
                    fraudRequest.idType(), fraudRequest.idValue());
            return true;
        }

        fraudCustomerRepository.save(FraudCustomer.builder()
                .idType(idType)
                .idValue(idValue)
                .createdAt(LocalDateTime.now())
                .build());

        return false;
    }

}

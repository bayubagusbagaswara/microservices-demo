package com.bayu.repository;

import com.bayu.model.FraudCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudCustomerRepository extends JpaRepository<FraudCustomer, Integer> {

    Optional<FraudCustomer> findAllByIdTypeAndIdValue(String idType, String idValue);

}

package com.bayu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_value")
    private String idValue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

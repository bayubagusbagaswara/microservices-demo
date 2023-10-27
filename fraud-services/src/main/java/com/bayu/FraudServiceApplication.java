package com.bayu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class FraudServiceApplication {

    private static final Logger log = Logger.getLogger(FraudServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(FraudServiceApplication.class, args);
        log.info("Fraud Service is running...");
    }

}
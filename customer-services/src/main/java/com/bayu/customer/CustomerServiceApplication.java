package com.bayu.customer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class CustomerServiceApplication {

    private static final Logger log = Logger.getLogger(CustomerServiceApplication.class.getName());
    public static void main(String[] args) {
        log.info("Customer Service is running...");
    }

}
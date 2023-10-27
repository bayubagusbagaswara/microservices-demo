package com.bayu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    private static final Logger log = Logger.getLogger(EurekaServerApplication.class.getName());

    public static void main(String[] args) {
        log.info("Eureka Server is running...");
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
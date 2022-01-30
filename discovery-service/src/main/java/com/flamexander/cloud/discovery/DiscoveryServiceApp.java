package com.flamexander.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApp {
    // localhost:8761 - дашборд Эврики
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApp.class, args);
    }
}

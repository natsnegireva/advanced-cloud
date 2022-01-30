package com.flamexander.cloud.service.slow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient // анотация натройки подключения к эврике в appliction.yaml
@RestController
public class SlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SlowApplication.class, args);
    }

    @GetMapping("/api/v1/slow")
    public String getData(@RequestParam(defaultValue = "0") Long delay) throws InterruptedException {
        Thread.sleep(delay);
        return "Вернуть - Slow Data";
    }
}

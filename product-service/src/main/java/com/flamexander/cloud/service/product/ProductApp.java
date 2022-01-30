package com.flamexander.cloud.service.product;

import com.flamexander.cloud.common.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProductApp {
    @Autowired
    private ProductController productController;
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        // RestTemplate синхронный метод отправки Rest-запросов
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }

    // ответ на запрос локальный
    @GetMapping("/api/v1/prod")
    public String getProductAns() {
        return "Hello my friend!!!";
    }

    @GetMapping("/api/v1/prod/products")
    public List<ProductDto> getProduct() {
        return productController.findAll ();
    }

}

package com.juliofhernandez.fullstackorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FullstackOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackOrderApplication.class, args);
    }

    /**
     * This RestTemplate is used to make REST calls to other microservices.
     * The @LoadBalanced annotation allows it to use Ribbon for client-side load balancing.
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

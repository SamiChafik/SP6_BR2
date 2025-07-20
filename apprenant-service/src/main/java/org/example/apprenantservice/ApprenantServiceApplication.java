package org.example.apprenantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApprenantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApprenantServiceApplication.class, args);
    }

}

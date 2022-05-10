package com.crudops.reactiveapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.crudops")
public class SpringReactiveCrudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveCrudAppApplication.class, args);
    }

}

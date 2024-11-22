package com.pedidosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pedidosapp")
public class PedidosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidosAppApplication.class, args);
    }
}

package com.zero.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server7001Main {
    public static void main(String[] args) {
        SpringApplication.run(Server7001Main.class,args);
    }
}

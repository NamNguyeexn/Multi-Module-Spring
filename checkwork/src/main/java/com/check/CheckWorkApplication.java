package com.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.check.*",
        "com.common.*",
//        "com.logger.*"
})
public class CheckWorkApplication {
//    @Autowired
//    private static ServerProperties serverProperties;
    public static void main(String[] args) {
//        System.out.println("PORT : " + serverProperties.getPort());
        SpringApplication.run(CheckWorkApplication.class, args);
    }
}
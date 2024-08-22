package com.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ComponentScan(basePackages = {
                "com.common.*","com.logger.*","com.check.*"
})
public class CheckWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckWorkApplication.class, args);
    }
}
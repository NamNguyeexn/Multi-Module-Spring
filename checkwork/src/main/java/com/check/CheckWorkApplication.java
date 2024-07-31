package com.check;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.common.*"})
public class CheckWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckWorkApplication.class, args);
    }
}
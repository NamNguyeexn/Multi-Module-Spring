package com.check;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.check.DTO.UsersCheckedIn;
import com.check.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {
                "com.common.*",
                "com.logger.*",
                "com.check.*"
})
public class CheckWorkApplication {
    public static void main(String[] args) {
        UsersCheckedIn.getInstance();
        SpringApplication.run(CheckWorkApplication.class, args);
    }
}
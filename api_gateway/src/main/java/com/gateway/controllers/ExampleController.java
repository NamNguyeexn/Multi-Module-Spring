package com.gateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/example/service")
    public ResponseEntity<String> exampleEndpoint() {
        return ResponseEntity.ok("Hello from the Example Microservice!");
    }
}

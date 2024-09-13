package com.check.chain_of_responsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoR_Controller {


    @GetMapping("/cor")
    public ResponseEntity<String> handleRequest(@RequestParam(name = "str") String request){
//        AuthorizationHandle authorizationHandle = new AuthorizationHandle();
        AuthenticationHandle authenticationHandle = new AuthenticationHandle();
        authenticationHandle.handleRequest(request);
//        authorizationHandle.handleRequest(request);
        return ResponseEntity.ok().body(request);
    }
}

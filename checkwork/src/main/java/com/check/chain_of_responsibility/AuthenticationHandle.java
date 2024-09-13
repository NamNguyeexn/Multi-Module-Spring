package com.check.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationHandle extends BaseHandle{
    @Override
    public void handleRequest(String request) {
        if(canHandle(request)){
            request += "\nHandling Authentication";
        } else {
            toNext(request);
        }
    }

    @Override
    public boolean canHandle(String request) {
        return request.contains("Authenticate");
    }
}


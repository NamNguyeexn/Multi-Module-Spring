package com.check.chain_of_responsibility;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationHandle extends BaseHandle{
    @Override
    public void handleRequest(String request) {
        if(requestHandle.canHandle(request)){
            System.out.println("Handle Authenticate");
        } else {
            toNext(request);
        }
    }

    @Override
    public boolean canHandle(String request) {
        return request.contains("Authorization");
    }
}

package com.check.chain_of_responsibility;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseHandle implements RequestHandle {
    protected RequestHandle requestHandle;

    public void setNextHandle(RequestHandle requestHandle){
        this.requestHandle = requestHandle;
    }
    protected void toNext(String request){
        if(requestHandle != null){
            requestHandle.canHandle(request);
        }
    }
}

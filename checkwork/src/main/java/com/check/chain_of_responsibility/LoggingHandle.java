package com.check.chain_of_responsibility;

public class LoggingHandle extends BaseHandle{
    @Override
    public void handleRequest(String request) {
        System.out.println("Logging Handle : " + request);
    }

    @Override
    public boolean canHandle(String request) {
        return false;
    }
}

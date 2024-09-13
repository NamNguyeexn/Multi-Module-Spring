package com.check.chain_of_responsibility;

public interface RequestHandle {
    void handleRequest(String request);
    boolean canHandle(String request);
}

package com.check.chain_of_responsibility.models;

public abstract class AuthenticationProcessor {
    public AuthenticationProcessor nextProcessor;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthorized(AuthenticationProcessor authProcessor);
}

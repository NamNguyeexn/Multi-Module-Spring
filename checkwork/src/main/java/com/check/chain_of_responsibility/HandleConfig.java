package com.check.chain_of_responsibility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandleConfig {
    @Bean
    public BaseHandle chainOfResponsibility() {
        AuthenticationHandle authHandle = new AuthenticationHandle();
        AuthorizationHandle authzHandle = new AuthorizationHandle();
        LoggingHandle loggingHandle = new LoggingHandle();
        authHandle.setNextHandle(authzHandle);
        authzHandle.setNextHandle(loggingHandle);
        return authHandle;
    }
}

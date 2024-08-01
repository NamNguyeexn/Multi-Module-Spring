package com.check.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface TestService {
    String getHelloService();
    Integer getSum(int a, int b);
    Integer getCounter(int a);
}

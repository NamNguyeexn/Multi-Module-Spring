package com.check.services.impl;

import com.check.services.TestService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
@Service

public class testserciceimpl implements TestService {

    @Override
    public String getHelloService() {
        return "HELLO FROM TEST SERVICE 8081";
    }

    @Override
    public Integer getSum(int a, int b) {
        return a + b;
    }

    @Override
    public Integer getCounter(int a) {
        return null;
    }
}

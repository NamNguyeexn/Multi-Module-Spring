package com.check.bridge.factory;

import org.springframework.stereotype.Component;

@Component
public interface ICreateEmployeeFactory {
    IEmployeeFactory getFactory(String employeeType);
}

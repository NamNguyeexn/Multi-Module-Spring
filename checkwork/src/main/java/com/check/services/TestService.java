package com.check.services;

import org.springframework.stereotype.Service;


@Service
public interface TestService {
    String getHello();
    String getData();
    void addData();
}

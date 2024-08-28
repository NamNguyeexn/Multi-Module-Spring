package com.check.services;

import org.springframework.stereotype.Service;


@Service
public interface ITestService {
    String getHello();
    String getData();
    void addData();
}

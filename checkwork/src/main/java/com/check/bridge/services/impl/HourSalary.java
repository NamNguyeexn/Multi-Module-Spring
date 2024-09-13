package com.check.bridge.services.impl;

import com.check.bridge.services.ISalary;

public class HourSalary implements ISalary {
    final long hourSalary = 20000;
    @Override
    public long calSalary() {
        return hourSalary;
    }

}

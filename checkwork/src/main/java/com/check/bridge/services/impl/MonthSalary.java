package com.check.bridge.services.impl;

import com.check.bridge.services.ISalary;

public class MonthSalary implements ISalary {
    final long monthSalary = 30000;
    private int day;

    public MonthSalary(int day) {
        this.day = day;
    }

    @Override
    public long calSalary() {
        return day * monthSalary * 8;
    }
}

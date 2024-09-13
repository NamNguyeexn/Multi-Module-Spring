package com.check.bridge.models;

import com.check.bridge.services.ISalary;
import com.check.models.User;

public abstract class Employee {
    protected ISalary salary;

    protected Employee(ISalary salary) {
        this.salary = salary;
    }

    abstract Employee getEmployee(User user);
    abstract String getEmployeeCode(User user);

    public abstract long getHourlySalary();
    public abstract long getMonthlySalary(int day);
}

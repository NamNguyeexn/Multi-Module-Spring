package com.check.bridge.models;

import com.check.bridge.services.ISalary;
import com.check.bridge.services.impl.MonthSalary;
import com.check.models.ENUM.Role;
import com.check.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff extends Employee {
    private String name;
    private Role role;
    private String employeeCode;
    private final long HOURLY = 20000;

    public Staff(ISalary salary) {
        super(salary);
    }

    public Staff(ISalary salary, String name, Role role, String employeeCode) {
        super(salary);
        this.name = name;
        this.role = role;
        this.employeeCode = employeeCode;
    }

    @Override
    Employee getEmployee(User user) {
        return new Staff(salary, name, role, employeeCode);
    }

    @Override
    String getEmployeeCode(User user) {
        return this.employeeCode;
    }

    @Override
    public long getHourlySalary() {
        return HOURLY;
    }

    @Override
    public long getMonthlySalary(int day) {
        ISalary salary1 = new MonthSalary(day);
        return salary1.calSalary();
    }
}

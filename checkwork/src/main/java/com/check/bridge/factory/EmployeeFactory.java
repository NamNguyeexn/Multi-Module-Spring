package com.check.bridge.factory;

import com.check.bridge.models.Employee;
import com.check.bridge.services.ISalary;
import com.check.models.ENUM.Role;
/**
 * Can phai viet lai bang factory method
 * */
public abstract class EmployeeFactory {
    public abstract Employee getEmployeeFactory(ISalary salary, String name, Role role, String employeeCode);
}

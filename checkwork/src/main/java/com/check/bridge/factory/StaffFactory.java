package com.check.bridge.factory;

import com.check.bridge.models.Employee;
import com.check.bridge.models.Staff;
import com.check.bridge.services.ISalary;
import com.check.models.ENUM.Role;

public class StaffFactory extends EmployeeFactory{
    @Override
    public Employee getEmployeeFactory(ISalary salary, String name, Role role, String employeeCode) {
        return new Staff(salary, name, role, employeeCode);
    }
}

package com.check.bridge.factory;

import com.check.bridge.models.Employee;
import com.check.bridge.models.Manager;
import com.check.bridge.services.ISalary;
import com.check.models.ENUM.Role;
import org.springframework.stereotype.Component;

@Component
public class ManageFactory implements IEmployeeFactory{
    @Override
    public Employee getEmployeeFactory(ISalary salary, String name, Role role, String employeeCode) {
        return new Manager(salary, name, role, employeeCode);
    }
}

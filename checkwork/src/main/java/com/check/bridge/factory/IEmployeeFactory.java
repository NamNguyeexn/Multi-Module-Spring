package com.check.bridge.factory;

import com.check.bridge.models.Employee;
import com.check.bridge.services.ISalary;
import com.check.models.ENUM.Role;
import org.springframework.stereotype.Component;

@Component
public interface IEmployeeFactory {
    Employee getEmployeeFactory(ISalary salary, String name, Role role, String employeeCode);
}

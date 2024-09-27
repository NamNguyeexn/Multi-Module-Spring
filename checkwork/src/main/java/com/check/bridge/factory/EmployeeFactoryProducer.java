package com.check.bridge.factory;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFactoryProducer implements ICreateEmployeeFactory{
    @Override
    public IEmployeeFactory getFactory(String employeeType) {
        if(employeeType.equalsIgnoreCase("ADMIN")){
            return new ManageFactory();
        } else if (employeeType.equalsIgnoreCase("USER")){
            return new StaffFactory();
        }
        return null;
    }

//    public EmployeeFactory getFactory(String employeeType){
//        if(employeeType.equalsIgnoreCase("ADMIN")){
//            return new ManageFactory();
//        } else if (employeeType.equalsIgnoreCase("USER")){
//            return new StaffFactory();
//        }
//        return null;
//    }
}

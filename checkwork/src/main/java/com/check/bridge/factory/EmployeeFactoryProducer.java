package com.check.bridge.factory;

public class EmployeeFactoryProducer {
    public static EmployeeFactory getFactory(String employeeType){
        if(employeeType.equalsIgnoreCase("ADMIN")){
            return new ManageFactory();
        } else if (employeeType.equalsIgnoreCase("USER")){
            return new StaffFactory();
        }
        return null;
    }
}

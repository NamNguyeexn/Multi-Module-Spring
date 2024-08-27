package com.dpbuilder.builders;

import com.dpbuilder.models.User;

public class AdminBuilder implements Builder{
    private String name;
    private String department;
    private String address;
    private String phone;
    private String email;
    private String role;
//    private boolean isActive;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
    public User builder(){
        return new User(name, phone, address, department, email, role);
    }
//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
}

package com.dpbuilder.models;

import com.dpbuilder.builders.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String department;
    private final String address;
    private final String phone;
    private final String email;
    private final String role;

    public User(String name, String department, String address, String phone, String email, String role) {
        this.name = name;
        this.department = department;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
//        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

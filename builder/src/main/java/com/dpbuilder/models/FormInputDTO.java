package com.dpbuilder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormInputDTO {
    private String name;
    private String department;
    private String address;
    private String phone;
    private String email;

    public FormInputDTO(String name, String department, String address, String phone, String email) {
        this.name = name;
        this.department = department;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

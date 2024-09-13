package com.check.bridge.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DetailEmployee {
    private String name;
    private String role;
    private String employeeCode;
    private long salary;
    private String department;
    private String email;
}

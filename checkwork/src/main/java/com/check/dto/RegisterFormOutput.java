package com.check.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterFormOutput {
    private String employeeCode;
    private String name;
    //    @ValidUsernameCharacter
//    @ValidUsernameLength
    private String username;
    //    @ValidPasswordCharacter
//    @ValidPasswordLength
    private String password;
    private String email;
    private String department;
}

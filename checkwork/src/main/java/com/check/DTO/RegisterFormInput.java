package com.check.DTO;

import com.common.validations.*;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterFormInput {
    @NotBlank(message = "Name cant be null")
    private String name;
    @NotBlank(message = "Date of birth cant be null")
    @ValidDateOfBirthInput
    private String dob;
    @NotBlank(message = "Address cant be null")
    private String address;
    @NotBlank(message = "Email cant be null")
    @ValidEmailCharacter
    private String email;
    @NotBlank(message = "Phone cant be null")
    @ValidPhoneNumberCharacter
    @Size(max = 10, min = 10, message = "Length is not valid")
    private String phone;
    @NotBlank(message = "Username cant be null")
    @ValidUsernameCharacter
    @Size(max = 5, min = 3, message = "Username is 3 - 5 characters")
    private String username;
    @NotBlank(message = "Password cant be null")
    @ValidPasswordCharacter
    @Size(max = 5, min = 3, message = "Password is 3 - 5 characters")
    private String password;
    @NotBlank(message = "Department cant be null")
    @ValidDepartment
    private String department;
}

package com.check.DTO;

import com.common.validations.login.*;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(namespace = "name")
    private String name;
    @NotBlank(message = "Date of birth cant be null")
    @ValidDateOfBirthInput
    private String dob;
    @NotBlank(message = "Address cant be null")
    @JsonProperty(namespace = "address")
    private String address;
    @NotBlank(message = "Email cant be null")
    @ValidEmailCharacter
    private String email;
    @NotBlank(message = "Phone cant be null")
    @ValidPhoneNumberCharacter
    @Size(max = 10, min = 10, message = "Length is not valid")
    @JsonProperty(namespace = "phone")
    private String phone;
    @NotBlank(message = "Username cant be null")
    @ValidUsernameCharacter
    @Size(max = 5, min = 3, message = "Username is 3 - 5 characters")
    @JsonProperty(namespace = "username")
    private String username;
    @NotBlank(message = "Password cant be null")
    @ValidPasswordCharacter
    @Size(max = 5, min = 3, message = "Password is 3 - 5 characters")
    @JsonProperty(namespace = "password")
    private String password;
    @NotBlank(message = "Department cant be null")
    @ValidDepartment
    private String department;

    public @NotBlank(message = "Email cant be null") String getEmail() {
        return email;
    }
}

package com.check.dto;

import com.check.dto.ENUM.LOGIN_STATUS;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    @NotBlank(message = "Username cant be null")
//    @ValidUsernameCharacter
//    @ValidUsernameLength
    private String username;
    @NotBlank(message = "Password cant be null")
//    @ValidPasswordCharacter
//    @ValidPasswordLength
    private String password;
    private LOGIN_STATUS status;
    public UserInput(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

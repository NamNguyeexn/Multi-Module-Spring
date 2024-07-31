package com.check.DTO;

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
}

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
public class UserOutput {
    @NotBlank(message = "Username cant be null")
//    @ValidUsernameCharacter
//    @ValidUsernameLength
    private String username;
}

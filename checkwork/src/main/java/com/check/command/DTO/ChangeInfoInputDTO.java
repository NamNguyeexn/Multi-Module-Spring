package com.check.command.DTO;

import com.common.validations.login.ValidEmailCharacter;
import com.common.validations.login.ValidPasswordCharacter;
import com.common.validations.login.ValidUsernameCharacter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ChangeInfoInputDTO {
    @ValidEmailCharacter
    private String email;
    @ValidUsernameCharacter
    private String username;
    @ValidPasswordCharacter
    private String password;
    private String role;
    private String department;
    private String messageStr;
}

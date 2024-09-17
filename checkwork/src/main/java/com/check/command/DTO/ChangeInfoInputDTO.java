package com.check.command.DTO;

import com.common.validations.login.ValidEmailCharacter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ChangeInfoInputDTO {
    @ValidEmailCharacter
    private String email;
    private String username;
    private String password;
    private String role;
    private String department;
    private String messageStr;
}

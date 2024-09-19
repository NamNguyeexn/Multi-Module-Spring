package com.check.mediator.DTO;

import com.common.validations.login.ValidEmailCharacter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterChatDTO {
//    @ValidEmailCharacter
    private String[] emails;
}

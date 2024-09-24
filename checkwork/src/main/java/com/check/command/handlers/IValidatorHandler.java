package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;

public interface IValidatorHandler {
    boolean doValidator(ChangeInfoInputDTO changeInfoInputDTO);
}

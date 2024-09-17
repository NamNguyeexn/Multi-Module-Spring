package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;

public interface ValidatorHandler {
    boolean doValidator(ChangeInfoInputDTO changeInfoInputDTO);
}

package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    private ValidatorHandler validatorHandler;
    private final List<ValidatorHandler> list = new ArrayList<>();

    public ValidatorChain() {
    }

    public ValidatorChain(ValidatorHandler validatorHandler) {
        this.validatorHandler = validatorHandler;
    }

    public void doHandle(ChangeInfoInputDTO changeInfoInputDTO) {
//        for (ValidatorHandler v : list) {
//            if (!v.doValidator(changeInfoInputDTO)) {
//                break;
//            }
//        }
        list.forEach(l -> l.doValidator(changeInfoInputDTO));
    }

    public ValidatorChain setHandle(ValidatorHandler validatorHandler) {
        this.validatorHandler = validatorHandler;
        list.add(validatorHandler);
        return this;
    }
}

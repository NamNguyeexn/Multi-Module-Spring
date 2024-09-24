package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    private IValidatorHandler IValidatorHandler;
    private final List<IValidatorHandler> list = new ArrayList<>();

    public ValidatorChain() {
    }

    public ValidatorChain(IValidatorHandler IValidatorHandler) {
        this.IValidatorHandler = IValidatorHandler;
    }

    public void doHandle(ChangeInfoInputDTO changeInfoInputDTO) {
//        for (IValidatorHandler v : list) {
//            if (!v.doValidator(changeInfoInputDTO)) {
//                break;
//            }
//        }
        list.forEach(l -> l.doValidator(changeInfoInputDTO));
    }

    public ValidatorChain setHandle(IValidatorHandler IValidatorHandler) {
        this.IValidatorHandler = IValidatorHandler;
        list.add(IValidatorHandler);
        return this;
    }
}

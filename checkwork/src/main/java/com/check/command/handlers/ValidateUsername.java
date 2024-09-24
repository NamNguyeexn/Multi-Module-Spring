package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.repositories.JPARepository.UserRepository;

import static com.check.repositories.JPARepository.UserRepository.Specs.*;

public class ValidateUsername implements IValidatorHandler {
    private final UserRepository userRepository;

    public ValidateUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean doValidator(ChangeInfoInputDTO changeInfoInputDTO) {
        if(userRepository.findOne(byUsername(changeInfoInputDTO.getUsername())).isPresent()) {
            changeInfoInputDTO.setMessageStr("Username existed");
            return false;
        }
        return true;
    }
}

package com.check.command.handlers;

import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.repositories.JPARepository.UserRepository;

import static com.check.repositories.JPARepository.UserRepository.Specs.byEmail;

public class ValidateEmail implements IValidatorHandler {
    private final UserRepository userRepository;

    public ValidateEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean doValidator(ChangeInfoInputDTO changeInfoInputDTO) {
        if(userRepository.findOne(byEmail(changeInfoInputDTO.getEmail())).isPresent()){
            changeInfoInputDTO.setMessageStr("Email existed");
            return false;
        }
        return true;
    }
}

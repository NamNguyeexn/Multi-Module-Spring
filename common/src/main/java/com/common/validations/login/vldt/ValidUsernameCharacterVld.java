package com.common.validations.login.vldt;

import com.common.validations.login.ValidUsernameCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameCharacterVld implements ConstraintValidator<ValidUsernameCharacter, String> {
    @Override
    public void initialize(ValidUsernameCharacter constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        for (Character c : str.toCharArray()){
            if(!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
}

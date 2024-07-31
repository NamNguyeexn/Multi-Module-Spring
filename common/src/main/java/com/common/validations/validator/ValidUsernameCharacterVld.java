package com.common.validations.validator;

import com.common.validations.ValidUsernameCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidUsernameCharacterVld implements ConstraintValidator<ValidUsernameCharacter, String> {
    @Override
    public void initialize(ValidUsernameCharacter constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        String character = "^[a-zA-Z0-9]$";
        return Pattern.compile(character).matcher(str).matches();
    }
}

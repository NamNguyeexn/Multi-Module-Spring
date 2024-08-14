package com.common.validations.validator;

import com.common.validations.ValidPasswordCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;
@Slf4j
public class ValidPasswordCharacterVld implements ConstraintValidator<ValidPasswordCharacter, String> {
    @Override
    public void initialize(ValidPasswordCharacter constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
//        String checkStr  = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;

    }
}

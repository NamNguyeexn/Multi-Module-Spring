package com.common.validations.validator;

import com.common.validations.ValidDateOfBirthInput;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidDateOfBirthInputVld implements ConstraintValidator<ValidDateOfBirthInput, String> {
    @Override
    public void initialize(ValidDateOfBirthInput constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        String pattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(pattern, str);
    }
}

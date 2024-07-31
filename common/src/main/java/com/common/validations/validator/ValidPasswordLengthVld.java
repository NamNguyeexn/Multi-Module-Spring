package com.common.validations.validator;

import com.common.validations.ValidPasswordLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidPasswordLengthVld implements ConstraintValidator<ValidPasswordLength, String> {
    @Override
    public void initialize(ValidPasswordLength constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        return str.length() >= 3 && str.length() <= 8;
    }
}

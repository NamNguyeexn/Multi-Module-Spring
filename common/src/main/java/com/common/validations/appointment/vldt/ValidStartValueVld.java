package com.common.validations.appointment.vldt;

import com.common.validations.appointment.ValidStartValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidStartValueVld implements ConstraintValidator<ValidStartValue, String> {
    @Override
    public void initialize(ValidStartValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime start = LocalDateTime.parse(s,formatter);
        if(start.isBefore(LocalDateTime.now())) return false;

        return true;
    }
}

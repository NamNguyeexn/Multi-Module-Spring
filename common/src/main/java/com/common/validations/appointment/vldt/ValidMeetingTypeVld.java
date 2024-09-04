package com.common.validations.appointment.vldt;

import com.common.validations.appointment.ValidMeetingType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidMeetingTypeVld implements ConstraintValidator<ValidMeetingType, String> {
    private final String[] arr = {"ONLINE", "OFFLINE"};
    private final List<String> list = Arrays.asList(arr);
    @Override
    public void initialize(ValidMeetingType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isEmpty()) {
            return false;
        }
        return list.contains(s);
    }
}

package com.common.validations.validator;

import com.common.validations.ValidMeetingType;
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
        return list.contains(s);
    }
}

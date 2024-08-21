package com.common.validations.validator;

import com.common.validations.ValidDepartment;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidDepartmentVld implements ConstraintValidator<ValidDepartment, String> {
    private final String[] arr = {"SALES", "PRODUCTION", "HUMANS"};
    private final List<String> departments = Arrays.asList(arr);
    @Override
    public void initialize(ValidDepartment constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return departments.contains(s);
    }
}

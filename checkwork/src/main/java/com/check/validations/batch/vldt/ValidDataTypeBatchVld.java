package com.check.validations.batch.vldt;

import com.check.validations.batch.ValidDataTypeBatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class ValidDataTypeBatchVld implements ConstraintValidator<ValidDataTypeBatch, String> {
    @Override
    public void initialize(ValidDataTypeBatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> dataType = new ArrayList<>();
        dataType.add("schedule");
        dataType.add("perevaluation");
        dataType.add("userstate");
        return dataType.contains(s);
    }
}

package com.check.validations.vldt;

import com.check.DTO.AppointmentFormInput;
import com.check.validations.ValidStartAndEnd;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidStartAndEndVld implements ConstraintValidator<ValidStartAndEnd, AppointmentFormInput> {

    @Override
    public void initialize(ValidStartAndEnd constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AppointmentFormInput appointment, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime start = LocalDateTime.parse(appointment.getStart(), formatter),
                end = LocalDateTime.parse(appointment.getEnd(), formatter);
        return start.isBefore(end.plusHours(2));
    }
}

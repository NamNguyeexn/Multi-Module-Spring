package com.common.validations.appointment;

import com.common.validations.appointment.vldt.ValidTimeCharacterVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidTimeCharacterVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTimeCharacter {
    String message() default "Time must be 'yyyy-MM-dd'T'HH:mm'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

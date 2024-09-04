package com.common.validations.appointment;

import com.common.validations.appointment.vldt.ValidStartValueVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidStartValueVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStartValue {
    String message() default "Appointment must be in future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

//public @interface ValidTimeCharacter {

//}
package com.common.validations.appointment;

import com.common.validations.appointment.vldt.ValidMeetingTypeVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidMeetingTypeVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMeetingType {
    String message() default "Meeting type not available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

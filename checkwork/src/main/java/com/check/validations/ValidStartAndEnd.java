package com.check.validations;

import com.check.validations.vldt.ValidStartAndEndVld;
import com.common.validations.appointment.vldt.ValidMeetingTypeVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidStartAndEndVld.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStartAndEnd {
    String message() default "Meeting type not available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

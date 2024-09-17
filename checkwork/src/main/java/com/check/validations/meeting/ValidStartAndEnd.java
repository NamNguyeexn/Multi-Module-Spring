package com.check.validations.meeting;

import com.check.validations.meeting.vldt.ValidStartAndEndVld;
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

package com.common.validations;

import com.common.validations.validator.ValidDateOfBirthInputVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDateOfBirthInputVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateOfBirthInput {
    String message() default "Date ob birth not yyyy-mm-dd";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.common.validations.login;

import com.common.validations.login.vldt.ValidDateOfBirthVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDateOfBirthVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateOfBirth {
    String message() default "User cant under 18 years old";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

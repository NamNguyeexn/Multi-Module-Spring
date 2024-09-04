package com.common.validations.login;

import com.common.validations.login.vldt.ValidEmailCharacterVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEmailCharacterVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailCharacter {
    String message() default "Email address is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

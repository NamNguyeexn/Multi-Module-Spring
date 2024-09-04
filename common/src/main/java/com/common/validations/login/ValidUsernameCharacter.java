package com.common.validations.login;

import com.common.validations.login.vldt.ValidUsernameCharacterVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidUsernameCharacterVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsernameCharacter {
    String message() default "Username only have A - Z, a - z, 0 - 9";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

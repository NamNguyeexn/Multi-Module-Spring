package com.common.validations.login;

import com.common.validations.login.vldt.ValidPasswordCharacterVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPasswordCharacterVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPasswordCharacter {
    String message() default "Password only A - Z, a - z, 0 - 9";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

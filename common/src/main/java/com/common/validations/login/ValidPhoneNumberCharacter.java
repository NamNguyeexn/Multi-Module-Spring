package com.common.validations.login;

import com.common.validations.login.vldt.ValidPhoneNumberCharacterVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneNumberCharacterVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumberCharacter {
    String message() default "The phone number must only 0 - 9";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

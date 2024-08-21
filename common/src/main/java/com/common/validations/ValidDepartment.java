package com.common.validations;

import com.common.validations.validator.ValidDepartmentVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDepartmentVld.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDepartment {
    String message() default "Department not available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

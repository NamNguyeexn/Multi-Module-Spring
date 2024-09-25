package com.check.validations.batch;

import com.check.validations.batch.vldt.ValidDataTypeBatchVld;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDataTypeBatchVld.class)
@Target({ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDataTypeBatch {
    String message() default "Data type not available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.common.validations.validator;

import com.common.validations.ValidEmailCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class ValidEmailCharacterVld implements ConstraintValidator<ValidEmailCharacter, String> {
    @Override
    public void initialize(ValidEmailCharacter constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.contains("@")) {
            return false;
        } else {
            String[] datas = s.split("@");
            for (String data : datas) {
                if(data.isEmpty()){
                    return false;
                }
                for (Character character : data.toCharArray()) {
                    if(character.compareTo('.') == 0) continue;
                    if (!Character.isLetterOrDigit(character)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

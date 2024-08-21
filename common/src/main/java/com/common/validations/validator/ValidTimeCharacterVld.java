package com.common.validations.validator;

import com.common.validations.ValidTimeCharacter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class ValidTimeCharacterVld implements ConstraintValidator<ValidTimeCharacter, String> {
    @Override
    public void initialize(ValidTimeCharacter constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        if(localDateTime == null || localDateTime.trim().isEmpty()) {
            return false;
        }
        String[] data = localDateTime.trim().split("&");
        ////////////
        System.out.println("CHAR AT 10 " + localDateTime.charAt(10));
        return validDate(data[0]) && validTime(data[1]) ;
    }
    private boolean validDate(String data){
        for(Character c : data.toCharArray()){
            if (c.compareTo('-') != 0){
                if(!Character.isDigit(c)) return false;
            }
        }
        String[] date = data.split("-");
        if(date.length < 3) return false;
        for(String d : date) if(d.isEmpty()) return false;
        if(date[0].length() != 4 || date[1].length() > 2 || date[2].length() > 2) return false;
        if(Integer.parseInt(date[2]) > 32 || Integer.parseInt(date[1]) > 13) return false;
        return true;
    }
    private boolean validTime(String data){
        for(Character c : data.toCharArray()){
            if (c.compareTo(':') != 0){
                if(!Character.isDigit(c)) return false;
            }
        }
        String[] time = data.split(":");
        if(time.length < 2) return false;
        if(Integer.parseInt(time[0]) > 24 || Integer.parseInt(time[1]) > 60) return false;
        return true;
    }
}

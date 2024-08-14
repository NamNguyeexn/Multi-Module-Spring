package com.check.mapper;

import com.check.DTO.RegisterFormInput;
import com.check.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T15:59:38+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User inputRegisterToUser(RegisterFormInput registerFormInput, int idHuman, String role, String employeeCode) {
        if ( registerFormInput == null && role == null && employeeCode == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}

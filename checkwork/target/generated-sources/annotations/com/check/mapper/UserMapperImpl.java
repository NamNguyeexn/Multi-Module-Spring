package com.check.mapper;

import com.check.DTO.RegisterFormInput;
import com.check.models.ENUM.Department;
import com.check.models.ENUM.Role;
import com.check.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T17:16:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User inputRegisterToUser(RegisterFormInput registerFormInput, int idHuman, String role, String employeeCode) {
        if ( registerFormInput == null && role == null && employeeCode == null ) {
            return null;
        }

        User user = new User();

        if ( registerFormInput != null ) {
            user.setUsername( registerFormInput.getUsername() );
            user.setPassword( registerFormInput.getPassword() );
            user.setEmail( registerFormInput.getEmail() );
            if ( registerFormInput.getDepartment() != null ) {
                user.setDepartment( Enum.valueOf( Department.class, registerFormInput.getDepartment() ) );
            }
        }
        if ( role != null ) {
            user.setRole( Enum.valueOf( Role.class, role ) );
        }
        if ( employeeCode != null ) {
            user.setEmployeeCode( employeeCode );
        }
        user.setHumanid( idHuman );

        return user;
    }
}

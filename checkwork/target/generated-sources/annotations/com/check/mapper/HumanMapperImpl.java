package com.check.mapper;

import com.check.DTO.RegisterFormInput;
import com.check.DTO.RegisterFormOutput;
import com.check.models.Human;
import com.check.models.User;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T16:24:19+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class HumanMapperImpl implements HumanMapper {

    @Override
    public RegisterFormOutput userToRegisterFormOutput(User user, RegisterFormInput humanInput, String password) {
        if ( user == null && humanInput == null && password == null ) {
            return null;
        }

        RegisterFormOutput registerFormOutput = new RegisterFormOutput();

        if ( user != null ) {
            registerFormOutput.setEmployeeCode( user.getEmployeeCode() );
            registerFormOutput.setUsername( user.getUsername() );
            registerFormOutput.setEmail( user.getEmail() );
            if ( user.getDepartment() != null ) {
                registerFormOutput.setDepartment( user.getDepartment().name() );
            }
        }
        if ( humanInput != null ) {
            registerFormOutput.setName( humanInput.getName() );
        }
        if ( password != null ) {
            registerFormOutput.setPassword( password );
        }

        return registerFormOutput;
    }

    @Override
    public Human registerFormInputToHuman(RegisterFormInput humanInput, Date dob) {
        if ( humanInput == null && dob == null ) {
            return null;
        }

        Human human = new Human();

        if ( humanInput != null ) {
            human.setName( humanInput.getName() );
            human.setAddress( humanInput.getAddress() );
            human.setPhone( humanInput.getPhone() );
        }
        if ( dob != null ) {
            human.setDob( dob );
        }

        return human;
    }
}

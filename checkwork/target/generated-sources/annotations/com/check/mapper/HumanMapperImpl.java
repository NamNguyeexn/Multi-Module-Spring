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
    date = "2024-08-14T15:59:38+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class HumanMapperImpl implements HumanMapper {

    @Override
    public RegisterFormOutput userToRegisterFormOutput(User user, RegisterFormInput humanInput, String password) {
        if ( user == null && humanInput == null && password == null ) {
            return null;
        }

        RegisterFormOutput registerFormOutput = new RegisterFormOutput();

        return registerFormOutput;
    }

    @Override
    public Human registerFormInputToHuman(RegisterFormInput humanInput, Date dob) {
        if ( humanInput == null && dob == null ) {
            return null;
        }

        Human human = new Human();

        return human;
    }
}

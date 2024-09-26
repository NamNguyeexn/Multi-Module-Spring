package com.check.mapper;

import com.check.dto.RegisterFormInput;
import com.check.dto.RegisterFormOutput;
import com.check.models.Human;
import com.check.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

@Mapper(componentModel = "spring")
public interface IHumanMapper {
    IHumanMapper INSTANCE = Mappers.getMapper(IHumanMapper.class);

    @Mapping(source = "user.employeeCode", target = "employeeCode")
    @Mapping(source = "humanInput.name", target = "name")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.department", target = "department")
    RegisterFormOutput userToRegisterFormOutput(User user, RegisterFormInput humanInput, String password);

    @Mapping(source = "humanInput.name", target = "name")
    @Mapping(source = "dob", target = "dob")
    @Mapping(source = "humanInput.address", target = "address")
    @Mapping(source = "humanInput.phone", target = "phone")
    Human registerFormInputToHuman(RegisterFormInput humanInput, Date dob);
}

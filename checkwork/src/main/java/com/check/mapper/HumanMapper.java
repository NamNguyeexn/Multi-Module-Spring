package com.check.mapper;

import com.check.DTO.RegisterFormInput;
import com.check.DTO.RegisterFormOutput;
import com.check.models.Human;
import com.check.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

@Mapper(componentModel = "spring")
public interface HumanMapper {
    HumanMapper INSTANCE = Mappers.getMapper(HumanMapper.class);
//    @Mapping(source = "user.employeeCode", target = "employeeCode")
//    @Mapping(source = "humanInput.name", target = "name")
//    @Mapping(source = "user.username", target = "username")
//    @Mapping(source = "password", target = "password")
    RegisterFormOutput userToRegisterFormOutput(User user, RegisterFormInput humanInput, String password);
//    @Mapping(source = "humanInput.name", target = "name")
//    @Mapping(source = "dob", target = "dob")
//    @Mapping(source = "humanInput.address", target = "address")
//    @Mapping(source = "humanInput.phone", target = "phone")
    Human registerFormInputToHuman(RegisterFormInput humanInput, Date dob);
//    User registerFormInputToUser(RegisterFormInput registerFormInput);
}

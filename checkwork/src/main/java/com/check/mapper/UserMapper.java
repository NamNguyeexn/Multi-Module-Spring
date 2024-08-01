package com.check.mapper;

import com.check.DTO.RegisterFormInput;
import com.check.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//    @Mapping(source = "idHuman", target = "humanid")
//    @Mapping(source = "registerFormInput.username", target = "username")
//    @Mapping(source = "registerFormInput.password", target = "password")
//    @Mapping(source = "employeeCode", target = "employeeCode")
//    @Mapping(source = "role", target = "role")
    User inputRegisterToUser(RegisterFormInput registerFormInput, int idHuman, String role, String employeeCode);
}

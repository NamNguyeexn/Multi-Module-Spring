package com.check.mapper;

import com.check.dto.RegisterFormInput;
import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
//@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(source = "idHuman", target = "humanid")
    @Mapping(source = "registerFormInput.username", target = "username")
    @Mapping(source = "registerFormInput.password", target = "password")
    @Mapping(source = "employeeCode", target = "employeeCode")
    @Mapping(source = "registerFormInput.email", target = "email")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "registerFormInput.department", target = "department")
    User inputRegisterToUser(RegisterFormInput registerFormInput, int idHuman, String role, String employeeCode);

    @Mapping(source = "humanid", target = "humanid")
    @Mapping(source = "employeeCode", target = "employeeCode")
    @Mapping(source = "changeInfoInputDTO.email", target = "email")
    @Mapping(source = "changeInfoInputDTO.username", target = "username")
    @Mapping(source = "changeInfoInputDTO.password", target = "password")
    @Mapping(source = "changeInfoInputDTO.role", target = "role")
    @Mapping(source = "changeInfoInputDTO.department", target = "department")
    User changeInfoToUser(Integer humanid, String employeeCode, ChangeInfoInputDTO changeInfoInputDTO);
}

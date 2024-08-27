package com.dpbuilder.directors;

import com.dpbuilder.builders.Builder;
import com.dpbuilder.models.FormInputDTO;

public class AdminDirector {
    public void createAdmin(Builder builder, FormInputDTO formInputDTO){
        builder.setName(formInputDTO.getName());
        builder.setAddress(formInputDTO.getAddress());
        builder.setDepartment(formInputDTO.getDepartment());
        builder.setEmail(formInputDTO.getEmail());
        builder.setPhone(formInputDTO.getPhone());
        builder.setRole("ADMIN");
    }
}

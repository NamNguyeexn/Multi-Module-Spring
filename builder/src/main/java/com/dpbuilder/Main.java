package com.dpbuilder;

import com.dpbuilder.builders.AdminBuilder;
import com.dpbuilder.directors.AdminDirector;
import com.dpbuilder.models.FormInputDTO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AdminDirector adminDirector = new AdminDirector();
        AdminBuilder adminBuilder = new AdminBuilder();
        FormInputDTO formInputDTO = new FormInputDTO("Nam", "Sales", "2C Street", "0123456789", "nam@gmail.com");
        adminDirector.createAdmin(adminBuilder, formInputDTO);
        System.out.println(adminBuilder.builder().toString());
    }
}
package com.check.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.sql.Date;

@Entity
@Table(name = "human")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Scope
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
//    @ValidDateOfBirth
    private Date dob;
    private String address;
//    @ValidPhoneNumberCharacter
//    @ValidPhoneNumberLength
    private String phone;
}

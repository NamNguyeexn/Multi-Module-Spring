package com.check.models;

import com.check.models.ENUM.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@Table(name = "appointment")
public class Appointment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Appointment name cant be null")
    private String name;
    @Column(name = "hostid")
//    @NotBlank(message = "Host id cant be null")
    private int hostid;
    @Column(name = "joinid")
    @NotBlank(message = "Join id cant be null")
    private String joinid;
    @Column(name = "start")
    @NotNull(message = "Check in cant be null")
    private LocalDateTime start;
    @NotNull(message = "Check out cant be null")
    @Column(name = "end")
    private LocalDateTime end;
    @NotBlank(message = "Detail appointment cant be null")
    @Column(name = "detail")
    private String detail;
//    @NotBlank(message = "Type appointment cant be null")
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @NotBlank(message = "Room cant be null")
    @Column(name = "room")
    private String room;
    @Column(name = "info")
    private String info;
}

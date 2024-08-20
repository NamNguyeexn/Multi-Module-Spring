package com.check.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentFormInput {
    @NotBlank(message = "Name of appointment cant be null")
    private String name;
    @NotBlank(message = "Joins number cant be null")
    //// check ki
    private String joinid;
    @NotBlank(message = "Start cant be null")
    //valid thoi gian
    private LocalDateTime start;
    @NotBlank(message = "End cant be null")
    // valid thoi gian
    private LocalDateTime end;
    @NotBlank(message = "Detail cant be null")
    private String detail;
    @NotBlank(message = "Type of appointment cant be null")
    //valid kieu cuoc hop
    private String type;
}

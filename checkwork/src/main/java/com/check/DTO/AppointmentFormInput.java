package com.check.DTO;

import com.common.validations.ValidMeetingType;
import com.common.validations.ValidTimeCharacter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Name of appointment cant be null")
    private String name;
    @NotNull(message = "Joins number cant be null")
    //// check ki
    private String joinid;
    @ValidTimeCharacter
    //valid thoi gian
    private String start;
    @ValidTimeCharacter
    // valid thoi gian
    private String end;
    @NotNull(message = "Detail cant be null")
    private String detail;
    @ValidMeetingType
    @NotNull(message = "Type of appointment cant be null")
    private String type;
}

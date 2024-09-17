package com.check.DTO;

import com.check.validations.meeting.ValidStartAndEnd;
import com.common.validations.appointment.ValidMeetingType;
import com.common.validations.appointment.ValidTimeCharacter;
import com.common.validations.appointment.ValidStartValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidStartAndEnd
public class AppointmentFormInput {
    @NotNull(message = "Name of appointment cant be null")
    private String name;
    private String hostMail;
    @NotNull(message = "Joins number cant be null")
    //// check ki
    private String[] joinid;
    @ValidTimeCharacter
    @ValidStartValue
    private String start;
    @ValidTimeCharacter
    // valid thoi gian
    private String end;
    @NotNull(message = "Detail cant be null")
    private String detail;
    @ValidMeetingType
    private String type;

}

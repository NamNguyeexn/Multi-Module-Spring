package com.check.DTO;

import com.check.models.ENUM.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckInOutput {
    private String start;
    private String employeeCode;
    private Status status;
}

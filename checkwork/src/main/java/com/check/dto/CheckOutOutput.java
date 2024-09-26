package com.check.dto;

import com.check.models.ENUM.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutOutput {
    private String start;
//    @ValidCheckOutTime
    private String end;
    private String employeeCode;
    private Status status;
    private String note;
}

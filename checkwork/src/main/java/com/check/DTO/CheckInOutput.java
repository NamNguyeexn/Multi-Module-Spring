package com.check.DTO;

import com.check.models.ENUM.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class CheckInOutput {
    private LocalDateTime start;
    private String employeeCode;
    private Status status;
}

package com.check.DTO;

import com.check.models.ENUM.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckInOutput {
    private String start;
    private String employeeCode;
    @Builder.Default
    private Status status = Status.NOTDONE;
}

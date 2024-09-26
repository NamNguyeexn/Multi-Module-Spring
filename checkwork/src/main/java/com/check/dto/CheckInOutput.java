package com.check.dto;

import com.check.models.ENUM.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckInOutput {
    @JsonProperty(namespace = "start")
    private String start;
    @JsonProperty(namespace = "employeeCode")
    private String employeeCode;
    @JsonProperty(namespace = "status")
    @Builder.Default
    private Status status = Status.NOTDONE;
}

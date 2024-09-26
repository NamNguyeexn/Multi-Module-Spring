package com.check.dto;

import com.check.models.ENUM.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleOutput {
    private String start;
    private String end;
    @JsonProperty(namespace = "type")
    private Type type;
    @JsonProperty(namespace = "detail")
    private String detail;
    @JsonProperty(namespace = "hostname")
    private String hostname;
    private String[] joinname;

}

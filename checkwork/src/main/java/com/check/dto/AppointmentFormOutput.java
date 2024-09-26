package com.check.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentFormOutput {
    private String name;
    private String hostName;
    private String[] joinsName;
    private String start;
    private String end;
    private String detail;
    private String type;
    private String room;
    private String info;
}

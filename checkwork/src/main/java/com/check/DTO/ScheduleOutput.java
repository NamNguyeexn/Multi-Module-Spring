package com.check.DTO;

import com.check.models.ENUM.Type;
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
    private Type type;
    private String detail;
    private String hostname;
    private String[] joinname;

}

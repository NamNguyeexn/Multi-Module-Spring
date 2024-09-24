package com.check.batch.DTO;

import com.check.models.ENUM.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkHourBatch {
    private int id;
    private String start;
    private String end;
    private int userid;
    private Status status;
    private String note;
}

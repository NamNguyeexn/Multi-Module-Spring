package com.check.batch.DTO;

import com.check.models.ENUM.State;
import lombok.Data;

@Data
public class UserStateBatch {
    private int id;
    private State state;
    private int userid;
    private long salaryByHour;
}

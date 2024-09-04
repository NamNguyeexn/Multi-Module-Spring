package com.check.batch;

import com.check.models.ENUM.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class AppointmentBatch {
    private int id;
    private String name;
    private int hostid;
    private String joinid;
    private String start;
    private String end;
    private String detail;
    private Type type;
    private String room;
    private String info;
}
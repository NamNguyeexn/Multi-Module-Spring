package com.check.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offline implements Meeting{
    private String name;
    private int capacity;

    @Override
    public String getMeetingType() {
        return "OFFLINE";
    }

    @Override
    public String getRoomName() {
        return this.name;
    }
}

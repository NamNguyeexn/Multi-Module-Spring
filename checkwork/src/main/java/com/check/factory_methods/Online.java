package com.check.factory_methods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Online implements Meeting {
    private String name;
    private String platform;
    private String url;

    @Override
    public String getMeetingType() {
        return "ONLINE";
    }
    @Override
    public String getRoomName() {
        return this.name;
    }

}

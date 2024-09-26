package com.check.dto.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
@Setter
public class ResponseHandlerDTO {
    private String name;
    private int capacity;
    private boolean open;
    private String resString;
}

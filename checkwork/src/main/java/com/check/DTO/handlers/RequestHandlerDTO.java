package com.check.DTO.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@Setter
public class RequestHandlerDTO {
    /**
    * Room name
    * */
    private String name;
    private int capacity;
    private LocalDateTime start;
    private LocalDateTime end;
}

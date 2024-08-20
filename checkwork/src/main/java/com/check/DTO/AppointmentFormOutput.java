package com.check.DTO;

import com.check.models.ENUM.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentFormOutput {
    @NotBlank(message = "Name cant be null")
    private String name;
    @NotBlank(message = "Host name cant be null")
    private String hostName;
    @NotBlank(message = "Join name cant be null")
    private String[] joinsName;
    @NotBlank(message = "Start cant be null")
    private LocalDateTime start;
    @NotBlank(message = "End cant be null")
    private LocalDateTime end;
    @NotBlank(message = "Detail cant be null")
    private String detail;
    @NotBlank(message = "Type cant be null")
    private String type;
    @NotBlank(message = "Room cant be null")
    private String room;
    @NotBlank(message = "Info cant be null")
    private String info;
}

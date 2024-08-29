package com.check.models;

import com.check.models.ENUM.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "workhour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkHour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "start")
    @NotNull(message = "Check in cant be null")
    private LocalDateTime start;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "Check out cant be null")
    @Column(name = "end")
//    @ValidCheckOutTime
    private LocalDateTime end;
    @NotNull(message = "User Id cant be null")
    @Column(name = "userid")
    private int userid;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private Status status = Status.NOTDONE;
    @Nullable
    @Column(name = "note")
    private String note;

}

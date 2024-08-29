package com.check.models;


import com.check.models.ENUM.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
@Builder
public class Schedule {
    //Lớp tạo ra với mục đích sử dụng adapter và builder
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "hostname")
    private String hostname;
    @Column(name = "joinname")
    private String joinname;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;
    @Column(name = "detail")
    private String detail;

    public Schedule(String hostname, String joinname, LocalDateTime start, LocalDateTime end, Type type, String detail) {
        this.hostname = hostname;
        this.joinname = joinname;
        this.start = start;
        this.end = end;
        this.type = type;
        this.detail = detail;
    }
}

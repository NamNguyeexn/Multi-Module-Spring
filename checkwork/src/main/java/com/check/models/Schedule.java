package com.check.models;


import com.check.models.ENUM.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(namespace = "hostname")
    private String hostname;
    @Column(name = "joinname")
    private String joinname;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @JsonProperty(namespace = "type")
    private Type type;
    @Column(name = "detail")
    @JsonProperty(namespace = "detail")
    private String detail;

}

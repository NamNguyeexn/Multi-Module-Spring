package com.check.mediator.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "groupchat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Danh sach email co trong nhom
     * */
    private String[] emails;
    /**
     * Ten nhom chat
     * */
    private String name;
    /**
     * Thoi gian tao nhom chat
     * */
    private LocalDateTime createAt;
}

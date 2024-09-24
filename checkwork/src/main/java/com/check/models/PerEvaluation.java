package com.check.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "perevaluation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Column(name = "userstateid")
    private int userstateid;
//    @Column(name = "workhourid")
    private int workhourid;
    @Builder.Default
//    @Column(name = "efficiency")
    private double efficiency = 0.85;
    @Builder.Default
//    @Column(name = "rewardscore")
    private int rewardscore = 0;
    @Builder.Default
//    @Column(name = "punishscore")
    private int punishscore = 0;
}

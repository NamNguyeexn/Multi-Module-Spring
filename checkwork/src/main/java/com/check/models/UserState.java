package com.check.models;

import com.check.models.ENUM.State;
import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "userstate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private State state = State.RECRUITMENT;
    private int userid;
    @Builder.Default
    private long salaryByHour = 0;
}

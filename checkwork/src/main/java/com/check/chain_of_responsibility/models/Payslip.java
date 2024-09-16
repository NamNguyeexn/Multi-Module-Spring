package com.check.chain_of_responsibility.models;

import com.check.chain_of_responsibility.models.ENUM.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Payslip")
@Getter
@Setter
@Builder
public class Payslip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "goodsname")
    private String goodsname;
    @Column(name = "detail")
    private String detail;
    @Column(name = "time")
    private LocalDate time;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @Column(name = "value")
    private long value;
}

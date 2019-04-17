package com.nc.hrm.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.hpsf.Decimal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="record")
public class Record {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="apply_date")
    private Date applyDate;

    @Column(name="reason")
    private String reason;

    @Column(name="type")
    private Boolean type;

    @Column(name="amount")
    private Float amount;

    @Column(name="note")
    private String note;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;
}

package com.nc.hrm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dependent")
public class Dependent {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="relationship")
    private String relationship;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="note")
    private String note;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;
}

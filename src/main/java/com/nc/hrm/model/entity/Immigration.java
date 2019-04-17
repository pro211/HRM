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
@Table(name="immigration")
public class Immigration {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type")
    private String type;

    @Column(name="number")
    private String number;

    @Column(name="issued_by")
    private String issuedBy;

    @Column(name="issued_date")
    private Date issuedDate;

    @Column(name="expiry_date")
    private Date expiryDate;

    @Column(name="note")
    private String note;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;
}

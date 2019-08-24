package com.nc.hrm.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Salary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "social_security")
    private Long socialSecurity;

    @Column(name = "health_insurance")
    private Long healthInsurance;

    @Column(name = "personal_income_tax")
    private Long personalIncomeTax;

    @Column(name = "achievement")
    private Long achievement;

    @Column(name = "commission")
    private Long commission;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @Column(name = "basic_day_work")
    private Integer basicDayWork;

    @Column(name = "real_day_work")
    private Integer realDayWork;

    @Column(name = "overtime_days")
    private Integer overtimeDays;

    @Column(name = "overtime_percent")
    private Integer overtimePercent;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getTotalIncome(){
        Long totalIncome = (contract.getBaseSalary()/basicDayWork)*realDayWork
                + (contract.getBaseSalary()/basicDayWork)*(overtimePercent/100)*overtimeDays
                + contract.getSubsidiesSalary() + getTotalBonus() - getTotalDeduct();
        return totalIncome;
    }

    public Long getTotalDeduct() {
        return socialSecurity + healthInsurance + personalIncomeTax;
    }

    public Long getTotalBonus() {
        return achievement + commission;
    }
}
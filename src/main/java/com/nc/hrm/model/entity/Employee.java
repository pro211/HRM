package com.nc.hrm.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "gender", nullable = false)
    private Boolean gender = true;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "address_street_1")
    private String addressStreet1;

    @Column(name = "address_street_2")
    private String addressStreet2;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "zip_postal_code")
    private String zipPostalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "home_telephone")
    private String homeTelephone;

    @Column(name = "personal_mobile")
    private String personalMobile;

    @Column(name = "work_telephone")
    private String workTelephone;

    @Column(name = "work_email")
    private String workEmail;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "joined_date", nullable = false, updatable = false)
    private LocalDate joinedDate;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "admin", nullable = false)
    private Boolean admin = false;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "manager_id")
    private Long manageId;

}

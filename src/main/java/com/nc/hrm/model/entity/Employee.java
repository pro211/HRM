package com.nc.hrm.model.entity;


import com.nc.hrm.util.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "business_name")
    private String code;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
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
    private Integer maritalStatus;

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

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "joined_date")
    private LocalDate joinedDate;

    @Column(name = "active")
    private boolean isActive = true;

    @Column(name = "admin")
    private boolean isAdmin = false;

    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Contract> contract;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Leave> leave;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Achievement> achievement;

}

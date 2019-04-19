//package com.nc.hrm.model.service.impl;
//
//import com.nc.hrm.model.entity.Employee;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import javax.persistence.Column;
//import java.time.LocalDate;
//import java.util.Collection;
//
//@Getter
//@Setter
//public class EmployeeDetails extends User {
//
//    private Integer id;
//
//    private String businessName;
//
//    private String password;
//
//    private String name;
//
//    private String avatar;
//
//    private String identityNumber;
//
//    private Boolean gender;
//
//    private String nationality;
//
//    private LocalDate dateOfBirth;
//
//    private Integer maritalStatus;
//
//    private String addressStreet1;
//
//    private String addressStreet2;
//
//    private String city;
//
//    private String stateProvince;
//
//    private String zipPostalCode;
//
//    private String country;
//
//    private String homeTelephone;
//
//    private String personalMobile;
//
//    private String workTelephone;
//
//    private String workEmail;
//
//    private String personalEmail;
//
//    private String emergencyContact;
//
//    private LocalDate joinedDate;
//
//    private boolean isActive;
//
//    private boolean isAdmin;
//
//    public EmployeeDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Employee employee) {
//        super(username, password, authorities);
//        this.id = employee.getId();
//        this.businessName = employee.getBusinessName();
//        this.password ;
//        this.name;
//        this.avatar;
//        this.identityNumber;
//        this.gender;
//        this.nationality;
//        this.dateOfBirth;
//        this.maritalStatus;
//        this.addressStreet1;
//        this.addressStreet2;
//        this.city;
//        this.stateProvince;
//        this.zipPostalCode;
//        this.country;
//        this.homeTelephone;
//        this.personalMobile;
//        this.workTelephone;
//        this.workEmail;
//        this.personalEmail;
//        this.emergencyContact;
//        this.joinedDate;
//        this.isActive;
//        this.isAdmin;
//    }
//
//    public Employee toEntity() {
//        return new Employee(
//                this.id,
//                this.businessName,
//                this.password,
//                this.name,
//                this.avatar,
//                this.identityNumber,
//                this.gender,
//                this.nationality,
//
//        );
//    }
//}

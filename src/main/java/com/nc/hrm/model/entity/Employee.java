package com.nc.hrm.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nc.hrm.util.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "gender")
    private Boolean gender;

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
    private boolean isActive;

    @Column(name = "admin")
    private boolean isAdmin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Leave> leave;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Achievement> achievements;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return isAdmin
                ? Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
                : Arrays.asList(new SimpleGrantedAuthority("ROLE_EMPLOYEE")) ;
    }

    @Override
    public String getUsername() {
        return businessName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}

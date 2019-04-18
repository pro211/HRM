package com.nc.hrm.model.entity;


import com.nc.hrm.util.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {

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

    @Column(name = "avatar")
    private String avatar;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Contract> contract;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Leave> leave;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Achievement> achievement;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(isAdmin){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return code;
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

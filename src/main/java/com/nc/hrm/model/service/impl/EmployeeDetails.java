package com.nc.hrm.model.service.impl;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Value
public class EmployeeDetails extends User {

    private int employeeId;
    private String employeeName;

    public EmployeeDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int employeeId, String employeeName) {
        super(username, password, authorities);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
}

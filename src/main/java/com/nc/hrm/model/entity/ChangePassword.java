package com.nc.hrm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {
    private Integer id;
    private String password;
    private String newPassword;
    private String verifyPassword;

}

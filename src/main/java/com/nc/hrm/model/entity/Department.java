package com.nc.hrm.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private Set<Employee> employee;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private Set<JobTitle> jobTitles;

}

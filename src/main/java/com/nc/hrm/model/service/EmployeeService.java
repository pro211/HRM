package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Iterable<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> finById(int id);

    Employee findByBusinessName(String code);

    void delete(int id);
}

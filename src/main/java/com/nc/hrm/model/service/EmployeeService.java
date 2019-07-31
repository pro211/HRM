package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable page);

    List<Employee> fillAll();

    void save(Employee employee);

    Employee finById(int id);

    Employee findByBusinessName(String code);

    void delete(int id);
}

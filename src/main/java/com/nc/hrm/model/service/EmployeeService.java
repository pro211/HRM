package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<Department> findAll(Pageable page);

    List<Department> fillAll();

    void save(Employee employee);

    Employee finById(int id);

    Employee findByBusinessName(String code);

    void delete(int id);
}

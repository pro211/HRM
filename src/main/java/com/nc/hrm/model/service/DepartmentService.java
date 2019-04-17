package com.nc.hrm.model.service;


import com.nc.hrm.model.entity.Department;

import java.util.Optional;

public interface DepartmentService {

    Iterable<Department> findAll();

    void save(Department department);

    Optional<Department> finById(int id);

    void delete(int id);
}

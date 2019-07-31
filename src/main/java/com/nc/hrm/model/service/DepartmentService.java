package com.nc.hrm.model.service;


import com.nc.hrm.model.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentService {

    Page<Department> findAll(Pageable page);

    void save(Department department);

    Department findOne(int id);

    void delete(int id);
}

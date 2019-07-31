package com.nc.hrm.model.service;


import com.nc.hrm.model.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Page<Department> findAll(Pageable page);

    List<Department> fillAll();

    void save(Department department);

    Department findById(int id);

    void delete(int id);
}

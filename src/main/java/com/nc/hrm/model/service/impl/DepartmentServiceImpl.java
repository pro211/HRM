package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Branch;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Dependent;
import com.nc.hrm.model.repository.BranchRepository;
import com.nc.hrm.model.repository.DepartmentRepository;
import com.nc.hrm.model.service.BranchService;
import com.nc.hrm.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> finById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }
}

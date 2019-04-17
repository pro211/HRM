package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.repository.DepartmentRepository;
import com.nc.hrm.model.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
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

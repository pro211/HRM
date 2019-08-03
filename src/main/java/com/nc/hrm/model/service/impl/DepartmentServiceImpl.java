package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.repository.DepartmentRepository;
import com.nc.hrm.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Page<Department> findAll(Pageable page) {
        return departmentRepository.findAll(page);
    }

    @Override
    public List<Department> fillAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

}

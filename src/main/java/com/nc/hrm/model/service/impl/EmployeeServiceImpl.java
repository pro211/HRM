package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Branch;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.repository.BranchRepository;
import com.nc.hrm.model.repository.EmployeeRepository;
import com.nc.hrm.model.service.BranchService;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> finById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee findByCode(String code) {
        return employeeRepository.findByCode(code);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}

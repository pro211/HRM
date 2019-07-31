package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.repository.EmployeeRepository;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable page) {
        return employeeRepository.findAll(page);
    }

    @Override
    public List<Employee> fillAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee finById(int id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findByBusinessName(String businessName) {
        return employeeRepository.findByBusinessName(businessName);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}

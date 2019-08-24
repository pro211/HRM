package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Salary;
import com.nc.hrm.model.repository.SalaryRepository;
import com.nc.hrm.model.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Override
    public Page<Salary> findAll(Pageable page) {
        return salaryRepository.findAll(page);
    }

    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public Salary save(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public Salary findById(int id) {
        return salaryRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        salaryRepository.deleteById(id);
    }

    @Override
    public List<Salary> findByEmployeeId(int employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }
}

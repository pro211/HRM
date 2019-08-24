package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Salary;

import java.util.List;

public interface SalaryService extends BaseService<Salary, Integer>{
    List<Salary> findByEmployeeId(int employeeId);
}

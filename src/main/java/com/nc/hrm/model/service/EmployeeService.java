package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Employee;

public interface EmployeeService extends BaseService<Employee, Integer> {
    Employee findByBusinessName(String businessName);
}

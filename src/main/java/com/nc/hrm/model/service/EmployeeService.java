package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, Integer> {
    Employee findByBusinessName(String businessName);

    List<Employee> findByDepartmentId (int departmentId);
}

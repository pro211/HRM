package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    List<Salary> findByEmployeeId (int employeeId);
}

package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByBusinessName(String businessName);
    List<Employee> findByDepartmentId(int departmentId);
}

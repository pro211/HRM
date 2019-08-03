package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

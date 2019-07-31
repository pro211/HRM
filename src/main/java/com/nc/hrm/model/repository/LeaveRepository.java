package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    List<Leave> findByEmployeeId(int employeeId);
}

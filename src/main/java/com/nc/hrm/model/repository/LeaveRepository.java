package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
}

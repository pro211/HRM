package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveStatusRepository extends JpaRepository<LeaveStatus, Integer> {
}

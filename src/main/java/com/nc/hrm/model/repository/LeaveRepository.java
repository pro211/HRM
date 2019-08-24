package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    List<Leave> findByEmployeeId(int employeeId);
    List<Leave> findByStatusIdIsNot(int statusId);
    List<Leave> findByStatusId(int statusId);
}

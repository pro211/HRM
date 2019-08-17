package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findByEmployeeId (int employeeId);
    List<Contract> findByPositionId(int positionId);
}

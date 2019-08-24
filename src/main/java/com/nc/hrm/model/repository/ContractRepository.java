package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Contract findByCode(String code);

    List<Contract> findByEmployeeId (int employeeId);
    List<Contract> findByPositionId(int positionId);
}

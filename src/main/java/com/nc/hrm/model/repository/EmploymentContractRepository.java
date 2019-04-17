package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentContractRepository extends JpaRepository<Contract, Integer> {
}

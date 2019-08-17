package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {

}

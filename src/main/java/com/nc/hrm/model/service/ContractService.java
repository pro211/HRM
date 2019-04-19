package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Iterable<Contract> findAll();

    void save(Contract contract);

    Optional<Contract> finById(int id);

    void delete(int id);

    List<Contract> findByEmployeeId(int employeeId);
}

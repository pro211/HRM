package com.nc.hrm.model.service;
import com.nc.hrm.model.entity.Contract;

import java.util.List;

public interface ContractService extends BaseService<Contract, Integer> {
    List<Contract> findByEmployeeId(int employeeId);
    List<Contract> findByPositionId(int positionId);
}


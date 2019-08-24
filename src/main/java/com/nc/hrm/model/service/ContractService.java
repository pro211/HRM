package com.nc.hrm.model.service;
import com.nc.hrm.model.entity.Contract;

import java.util.List;

public interface ContractService extends BaseService<Contract, Integer> {
    Contract findByCode(String code);

    List<Contract> findByEmployeeId(int employeeId);
}


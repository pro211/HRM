package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.ContractType;
import com.nc.hrm.model.entity.Leave;

import java.util.List;

public interface LeaveService extends BaseService<Leave, Integer> {
    List<Leave> findByEmployeeId(int employeeId);
    List<Leave> findByStatusIdIsNot(int statusId);
    List<Leave> findByStatusId(int statusId);
}

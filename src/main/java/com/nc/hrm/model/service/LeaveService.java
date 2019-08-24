package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Leave;

import java.util.List;

public interface LeaveService extends BaseService<Leave, Integer> {
    List<Leave> findByEmployeeId(int employeeId);
    List<Leave> findByEmployeeIdAndS(int employeeId);
}

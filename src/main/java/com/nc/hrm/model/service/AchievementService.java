package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Achievement;

import java.util.List;

public interface AchievementService extends BaseService<Achievement, Integer> {
    List<Achievement> findByEmployeeId(int employeeId);
}

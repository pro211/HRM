package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementService {

    Iterable<Achievement> findAll();

    void save(Achievement achievement);

    Optional<Achievement> finById(int id);

    void delete(int id);

    List<Achievement> findByEmployeeId(int employeeId);
}

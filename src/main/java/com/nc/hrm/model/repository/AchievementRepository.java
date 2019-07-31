package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {
    List<Achievement> findByEmployeeId(int employeeId);
}

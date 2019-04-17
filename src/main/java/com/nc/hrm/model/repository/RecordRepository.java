package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Achievement, Integer> {
}

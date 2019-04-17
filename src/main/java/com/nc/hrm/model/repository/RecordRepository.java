package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}

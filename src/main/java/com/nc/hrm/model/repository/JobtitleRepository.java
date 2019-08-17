package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobtitleRepository extends JpaRepository<JobTitle, Integer> {
}

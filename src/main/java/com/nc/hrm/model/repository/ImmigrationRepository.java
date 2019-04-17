package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Immigration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmigrationRepository extends JpaRepository<Immigration, Integer> {
}

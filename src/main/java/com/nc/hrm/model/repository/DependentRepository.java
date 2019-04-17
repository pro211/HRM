package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {
}
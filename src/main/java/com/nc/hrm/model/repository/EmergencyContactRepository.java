package com.nc.hrm.model.repository;

import com.nc.hrm.model.entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Integer> {
}

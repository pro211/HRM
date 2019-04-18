package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Leave;

import java.util.Optional;

public interface LeaveService {

    Iterable<Leave> findAll();

    void save(Leave leave);

    Optional<Leave> finById(int id);

    void delete(int id);
}

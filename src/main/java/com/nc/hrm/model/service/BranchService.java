package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Branch;

import java.util.Optional;

public interface BranchService {
    Iterable<Branch> findAll();

    void save(Branch branch);

    Optional<Branch> finById(int id);

    void delete(int id);
}

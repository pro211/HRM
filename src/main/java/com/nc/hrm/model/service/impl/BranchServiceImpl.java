package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Branch;
import com.nc.hrm.model.repository.BranchRepository;
import com.nc.hrm.model.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public void save(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public Optional<Branch> finById(int id) {
        return branchRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        branchRepository.deleteById(id);
    }
}

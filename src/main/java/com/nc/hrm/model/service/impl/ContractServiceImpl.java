package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.repository.ContractRepository;
import com.nc.hrm.model.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public Optional<Contract> finById(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Contract> findByEmployeeId(int employeeId) {
        return null;
    }
}

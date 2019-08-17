package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.repository.ContractRepository;
import com.nc.hrm.model.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable page) {
        return contractRepository.findAll(page);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findByEmployeeId(int employeeId) {
        return contractRepository.findByEmployeeId(employeeId);
    }
}

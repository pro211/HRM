package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.ContractType;
import com.nc.hrm.model.repository.ContractTypeRepository;
import com.nc.hrm.model.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    ContractTypeRepository contractTypeRepository;

    @Override
    public Page<ContractType> findAll(Pageable page) {
        return contractTypeRepository.findAll(page);
    }

    @Override
    public List<ContractType> findAll() {
        return contractTypeRepository.findAll();
    }

    @Override
    public ContractType save(ContractType contractType) {
        return contractTypeRepository.save(contractType);
    }

    @Override
    public ContractType findById(int id) {
        return contractTypeRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        contractTypeRepository.deleteById(id);
    }
}

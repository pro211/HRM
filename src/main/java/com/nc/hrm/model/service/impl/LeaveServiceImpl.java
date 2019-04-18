package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Leave;
import com.nc.hrm.model.repository.DepartmentRepository;
import com.nc.hrm.model.repository.LeaveRepository;
import com.nc.hrm.model.service.DepartmentService;
import com.nc.hrm.model.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    @Override
    public Iterable<Leave> findAll() {
        return leaveRepository.findAll();
    }

    @Override
    public void save(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public Optional<Leave> finById(int id) {
        return leaveRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        leaveRepository.deleteById(id);
    }
}

package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Leave;
import com.nc.hrm.model.repository.LeaveRepository;
import com.nc.hrm.model.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    @Override
    public Page<Leave> findAll(Pageable page) {
        return leaveRepository.findAll(page);
    }

    @Override
    public List<Leave> findAll() {
        return null;
    }

    @Override
    public Leave save(Leave contract) {
        return null;
    }

    @Override
    public Leave findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

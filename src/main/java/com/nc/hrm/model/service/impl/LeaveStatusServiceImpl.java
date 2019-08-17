package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.LeaveStatus;
import com.nc.hrm.model.repository.LeaveStatusRepository;
import com.nc.hrm.model.service.LeaveStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveStatusServiceImpl implements LeaveStatusService {
    @Autowired
    LeaveStatusRepository leaveStatusRepository;

    @Override
    public Page<LeaveStatus> findAll(Pageable page) {
        return leaveStatusRepository.findAll(page);
    }

    @Override
    public List<LeaveStatus> findAll() {
        return leaveStatusRepository.findAll();
    }

    @Override
    public LeaveStatus save(LeaveStatus leaveStatus) {
        return leaveStatusRepository.save(leaveStatus);
    }

    @Override
    public LeaveStatus findById(int id) {
        return leaveStatusRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        leaveStatusRepository.deleteById(id);
    }
}

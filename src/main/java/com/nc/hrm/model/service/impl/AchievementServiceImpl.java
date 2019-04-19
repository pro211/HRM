package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.repository.AchievementRepository;
import com.nc.hrm.model.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Override
    public Iterable<Achievement> findAll() {
        return null;
    }

    @Override
    public void save(Achievement department) {

    }

    @Override
    public Optional<Achievement> finById(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Achievement> findByEmployeeId(int employeeId) {
        return null;
    }
}

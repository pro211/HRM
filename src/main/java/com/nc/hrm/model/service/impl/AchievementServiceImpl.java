package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.repository.AchievementRepository;
import com.nc.hrm.model.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    AchievementRepository achievementRepository;

    @Override
    public Page<Achievement> findAll(Pageable page) {
        return achievementRepository.findAll(page);
    }

    @Override
    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement save(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public Achievement findById(int id) {
        return achievementRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        achievementRepository.deleteById(id);
    }

    @Override
    public List<Achievement> findByEmployeeId(int employeeId) {
        return achievementRepository.findByEmployeeId(employeeId);
    }
}

package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.JobTitle;
import com.nc.hrm.model.repository.JobtitleRepository;
import com.nc.hrm.model.service.JobtitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobtitleServiceImpl implements JobtitleService {

    @Autowired
    JobtitleRepository jobtitleRepository;

    @Override
    public Page<JobTitle> findAll(Pageable page) {
        return jobtitleRepository.findAll(page);
    }

    @Override
    public List<JobTitle> findAll() {
        return jobtitleRepository.findAll();
    }

    @Override
    public JobTitle save(JobTitle jobTitle) {
        return jobtitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle findById(int id) {
        return jobtitleRepository.getOne(id);
    }

    @Override
    public void delete(int id) {
        jobtitleRepository.deleteById(id);
    }
}

package com.nc.hrm.model.service.impl;

import com.nc.hrm.model.entity.Certificate;
import com.nc.hrm.model.repository.CertificateRepository;
import com.nc.hrm.model.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public Iterable<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    public void save(Certificate certificate) {
        certificateRepository.save(certificate);
    }

    @Override
    public Optional<Certificate> finById(int id) {
        return certificateRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        certificateRepository.deleteById(id);
    }
}

package com.nc.hrm.model.service;

import com.nc.hrm.model.entity.Certificate;

import java.util.Optional;

public interface CertificateService {

    Iterable<Certificate> findAll();

    void save(Certificate certificate);

    Optional<Certificate> finById(int id);

    void delete(int id);
}

package com.nc.hrm.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
    Page<T> findAll(Pageable page);

    List<T> fillAll();

    T save(T t);

    T findById(int id);

    void delete(int id);
}

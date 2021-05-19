package com.ngs.service;

import com.ngs.entity.Operation;

import java.util.List;

public interface OperationService {
    List<Operation> findAll();

    Operation findById(Integer id);

    void save(Operation operation);

    void delete(Integer id);
}

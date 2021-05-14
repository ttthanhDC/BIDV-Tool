package com.ngs.service;

import com.ngs.entity.Operation;

public interface OperationService {
    void save(Operation operation);

    void delete(Integer id);
}

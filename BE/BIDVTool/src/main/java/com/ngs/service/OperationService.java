package com.ngs.service;

import com.ngs.entity.Operation;
import com.ngs.request.CreateOperationRequest;

import java.util.List;

public interface OperationService {
    List<Operation> findAll();

    Operation findById(Integer id);

    Operation save(CreateOperationRequest createOperationRequest);

    void delete(Integer id);
}

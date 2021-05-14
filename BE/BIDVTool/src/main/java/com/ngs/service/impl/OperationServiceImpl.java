package com.ngs.service.impl;

import com.ngs.entity.Operation;
import com.ngs.repository.OperationRepository;
import com.ngs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public void insertOperation(Operation operation) {
        operationRepository.save(operation);
    }
}

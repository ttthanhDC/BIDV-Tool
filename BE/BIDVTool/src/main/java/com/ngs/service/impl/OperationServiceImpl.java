package com.ngs.service.impl;

import com.ngs.entity.Operation;
import com.ngs.repository.OperationRepository;
import com.ngs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public void save(Operation operation) {
        operationRepository.save(operation);
    }

    @Override
    public void delete(Integer id) {
        Optional<Operation> operationOptional = operationRepository.findById(id);
        if (operationOptional.isPresent()) {
            operationRepository.delete(operationOptional.get());
        }
    }
}

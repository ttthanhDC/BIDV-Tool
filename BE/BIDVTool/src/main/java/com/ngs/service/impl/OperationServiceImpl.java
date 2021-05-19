package com.ngs.service.impl;

import com.ngs.entity.Operation;
import com.ngs.repository.OperationRepository;
import com.ngs.service.OperationService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public List<Operation> findAll() {
        Iterable<Operation> operations = operationRepository.findAll();
        if (operations != null) {
            return IterableUtils.toList(operations);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Operation findById(Integer id) {
        Optional<Operation> operationOptional = operationRepository.findById(id);
        if (operationOptional.isPresent()) {
            return operationOptional.get();
        }
        return null;
    }

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

package com.ngs.service.impl;

import com.ngs.entity.Operation;
import com.ngs.repository.OperationRepository;
import com.ngs.request.CreateOperationRequest;
import com.ngs.service.OperationService;
import com.ngs.service.ServicesService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ServicesService servicesService;

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
    public Operation save(CreateOperationRequest createOperationRequest) {
        com.ngs.entity.Service service = servicesService.getById(createOperationRequest.getServiceId());
        Objects.requireNonNull(service, "not found service by service id = " + createOperationRequest.getServiceId());

        Operation operation = Operation.builder()
                .applicationId(createOperationRequest.getApplicationId())
                .service(service)
                .interactWithCore(createOperationRequest.isInteractWithCore())
                .operationName(createOperationRequest.getOperationName())
                .status(createOperationRequest.getStatus())
                .ssdLegacy(createOperationRequest.getSsdLegacy())
                .ssdSOA(createOperationRequest.getSsdSOA())
                .isWorkshop(createOperationRequest.isWorkshop())
                .build();
        operationRepository.save(operation);
        return operation;
    }

    @Override
    public void delete(Integer id) {
        Optional<Operation> operationOptional = operationRepository.findById(id);
        if (operationOptional.isPresent()) {
            operationRepository.delete(operationOptional.get());
        }
    }
}

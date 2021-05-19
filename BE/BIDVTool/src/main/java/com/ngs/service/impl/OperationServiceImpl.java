package com.ngs.service.impl;

import com.ngs.constant.ErrorCode;
import com.ngs.entity.Operation;
import com.ngs.exception.DefinedException;
import com.ngs.repository.OperationRepository;
import com.ngs.repository.ServiceRepository;
import com.ngs.request.CreateOperationRequest;
import com.ngs.request.UpdateOperationRequest;
import com.ngs.response.UpdateOperationResponse;
import com.ngs.service.OperationService;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Operation> findAll() {
        Iterable<Operation> operations = operationRepository.findAll();
        return IterableUtils.toList(operations);
    }

    @Override
    public Operation findById(Integer id) throws Exception {
        Optional<Operation> operation = operationRepository.findById(id);
        if (!operation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + id);
        }
        return operation.get();
    }

    @Override
    public Operation save(CreateOperationRequest request) throws Exception {
        Optional<com.ngs.entity.Service> service = serviceRepository.findById(request.getServiceId());
        if (!service.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found service by id = " + request.getServiceId());
        }

        Operation operation = Operation.builder()
                .applicationId(request.getApplicationId())
                .service(service.get())
                .interactWithCore(request.isInteractWithCore())
                .operationName(request.getOperationName())
                .status(request.getStatus())
                .ssdLegacy(request.getSsdLegacy())
                .ssdSOA(request.getSsdSOA())
                .workshop(request.isWorkshop())
                .build();
        operationRepository.save(operation);
        return operation;
    }

    @Override
    public UpdateOperationResponse update(UpdateOperationRequest request, Integer id) throws Exception {
        Optional<Operation> operation = operationRepository.findById(id);
        if (!operation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "fail to update Operation by id = " + id);
        } else {
            Optional<com.ngs.entity.Service> service = serviceRepository.findById(request.getServiceId());
            if (!service.isPresent()) {
                throw new DefinedException(ErrorCode.NOT_FOUND, "not found service by id = " + request.getServiceId());
            }
            Operation updateOperation = operation.get();
            Operation previousOperation = SerializationUtils.clone(updateOperation);
            updateOperation.setOperationName(request.getOperationName());
            updateOperation.setService(service.get());
            updateOperation.setApplicationId(request.getApplicationId());
            updateOperation.setSsdLegacy(request.getSsdLegacy());
            updateOperation.setSsdSOA(request.getSsdSOA());
            updateOperation.setInteractWithCore(request.isInteractWithCore());
            updateOperation.setStatus(request.getStatus());
            updateOperation.setWorkshop(request.isWorkshop());
            operationRepository.save(updateOperation);
            return UpdateOperationResponse.builder()
                    .previousOperation(previousOperation)
                    .updatedOperation(updateOperation)
                    .build();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<Operation> operationOptional = operationRepository.findById(id);
        if (!operationOptional.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + id);
        }
        operationRepository.delete(operationOptional.get());
    }
}

package com.ngs.service;

import com.ngs.entity.Operation;
import com.ngs.request.CreateOperationRequest;
import com.ngs.request.UpdateOperationRequest;
import com.ngs.response.UpdateOperationResponse;

import java.util.List;

public interface OperationService {
    List<Operation> findAll();

    Operation findById(Integer id) throws Exception;

    Operation save(CreateOperationRequest createOperationRequest) throws Exception;

    UpdateOperationResponse update(UpdateOperationRequest request, Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}

package com.ngs.service;

import com.ngs.entity.Operation;

public interface OperationService {
    void insertOperation(Operation operation);

    void updateOperation(Integer operationId, Operation updatedOperation);


}

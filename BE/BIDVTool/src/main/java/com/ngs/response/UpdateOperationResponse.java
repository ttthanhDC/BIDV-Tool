package com.ngs.response;

import com.ngs.entity.Operation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOperationResponse {
    private Operation previousOperation;
    private Operation updatedOperation;
}

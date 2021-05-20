package com.ngs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOperationRequest {
    protected int serviceId;
    protected int applicationId;
    protected String operationName;
    protected boolean interactWithCore;
    protected String status;
    protected String ssdSOA;
    protected String ssdLegacy;
    protected boolean workshop;
}

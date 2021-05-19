package com.ngs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOperationRequest {
    private int serviceId;
    private int applicationId;
    private String operationName;
    private boolean interactWithCore;
    private String status;
    private String ssdSOA;
    private String ssdLegacy;
    private boolean workshop;
}

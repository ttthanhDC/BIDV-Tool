package com.ngs.response.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponse {
    private Integer operationId;
    private Integer serviceId;
    private Integer applicationId;
    private String operationName;
    private String serviceName;
    private String status;
    private String ssdSOA;
    private String ssdLegacy;
}

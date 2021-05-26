package com.ngs.response.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceByApp {
    private String applicationName;
    private Integer serviceId;
    private String serviceName;
    private String status;
}

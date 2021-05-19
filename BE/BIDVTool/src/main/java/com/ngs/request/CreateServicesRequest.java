package com.ngs.request;

import lombok.Data;

@Data
public class CreateServicesRequest {
    private String serviceName;
    private String status;
}

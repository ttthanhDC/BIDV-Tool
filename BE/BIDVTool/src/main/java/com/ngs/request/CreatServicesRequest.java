package com.ngs.request;

import lombok.Data;

@Data
public class CreatServicesRequest  extends BaseRequest{
    private String serviceName;
    private String status;
}

package com.ngs.request;

import lombok.Data;

@Data
public class CreateApplicationRequest {
    private String bidvAppCode;
    private String integrationAppCode;
    private String applicationName;
    private String abbreviation;
}

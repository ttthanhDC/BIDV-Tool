package com.ngs.request;

import lombok.Data;

@Data
public class CreatApplicationRequestBody {
    private String bidvAppCode;
    private String integrationAppCode;
    private String applicationName;
    private String abbreviation;
}

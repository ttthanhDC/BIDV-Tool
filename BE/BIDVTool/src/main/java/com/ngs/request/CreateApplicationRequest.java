package com.ngs.request;

import lombok.Data;

@Data
public class CreateApplicationRequest extends BaseRequest {
    protected String bidvAppCode;
    protected String integrationAppCode;
    protected String applicationName;
    protected String abbreviation;
    protected boolean inScope;

}

package com.ngs.response.bean;

import lombok.Data;

@Data
public class TotalAppResponse {
    private long totalInScope;
    private long totalNotInScope;
    private double inScopePercent;
    private double notInScopePercent;

}

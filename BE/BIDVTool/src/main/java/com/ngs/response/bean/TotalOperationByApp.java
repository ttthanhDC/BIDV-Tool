package com.ngs.response.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalOperationByApp {
    private String operationName;
    private String ServiceMerge;
    private Long count;
}

package com.ngs.response.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoingTask {
    private Integer taskId;
    private String taskDescription;
    private Integer operationId;
    private String operationName;
    private String serviceName;
    private String applicationName;
}

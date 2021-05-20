package com.ngs.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatTaskResponse {
    private String description;
    private Integer operationId;
    private String mappingSheet;
    private Date openDate;
    private Date dueDate;
    private Date closeDate;
    private String status;
}

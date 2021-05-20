package com.ngs.request;

import lombok.Data;

@Data
public class CreateIssueRequest {
    private String description;
    private int userId;
    private String resolution;
    private int operationId;
    private String owner;
    private String openDate;
    private String dueDate;
    private String closeDate;
    private String status;
    private String comment;
}

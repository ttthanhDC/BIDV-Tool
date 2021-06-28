package com.ngs.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateIssueRequest {
    private String description;
    private int reporterId;
    private String resolution;
    private int operationId;
    private String owner;
    private String support;
    private String openDate;
    private String dueDate;
    private String closeDate;
    private String status;
    private String comment;
    private String jraNumber;
}

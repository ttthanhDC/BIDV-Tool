package com.ngs.response.bean;

import com.ngs.entity.Operation;
import com.ngs.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Issue {
    private int id;
    private String description;
    private User reporter;
    private String resolution;
    private Operation operation;
    private String owner;
    private String openDate;
    private String dueDate;
    private String closeDate;
    private String status;
    private String comment;
}

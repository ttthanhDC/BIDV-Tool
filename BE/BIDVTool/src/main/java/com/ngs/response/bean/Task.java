package com.ngs.response.bean;

import com.ngs.entity.Operation;
import com.ngs.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private int id;
    private String description;
    private User assignee;
    private Operation operation;
    private String mappingSheet;
    private String openDate;
    private String dueDate;
    private String closeDate;
    private String status;
}

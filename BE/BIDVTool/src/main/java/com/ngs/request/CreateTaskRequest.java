package com.ngs.request;

import com.ngs.entity.Operation;
import com.ngs.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CreateTaskRequest {
    protected String description;
    protected Integer operationId;
    protected Integer assigneeId;
    protected String mappingSheet;
    protected String openDate;
    protected String dueDate;
    protected String closeDate;
    protected String status;

}

package com.ngs.request;

import com.ngs.entity.Operation;
import com.ngs.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class CreateTaskRequest {

    private String description;
    private Integer userId;
    private Integer operationId;
    private String mappingSheet;
    private Date openDate;
    private Date dueDate;
    private Date closeDate;
    private String status;

}

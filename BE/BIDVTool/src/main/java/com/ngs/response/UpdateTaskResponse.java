package com.ngs.response;

import com.ngs.entity.Task;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTaskResponse {
    private Task previousTask;
    private Task updateTask;
}

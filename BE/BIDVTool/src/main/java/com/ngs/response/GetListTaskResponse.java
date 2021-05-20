package com.ngs.response;

import com.ngs.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class GetListTaskResponse {
    List<Task> listTask;
}

package com.ngs.response;

import com.ngs.response.bean.Task;
import lombok.Data;

import java.util.List;

@Data
public class GetListTaskResponse {
    List<Task> listTask;
}

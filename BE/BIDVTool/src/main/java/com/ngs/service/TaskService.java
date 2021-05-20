package com.ngs.service;

import com.ngs.entity.Task;
import com.ngs.request.CreateTaskRequest;
import com.ngs.request.UpdateTaskRequest;
import com.ngs.response.UpdateTaskResponse;

import java.util.List;

public interface TaskService {
    List<Task> getAll() throws Exception;

    Task getById(Integer id) throws Exception;

    Task save(CreateTaskRequest request) throws Exception;

    UpdateTaskResponse update(UpdateTaskRequest request, Integer id) throws Exception;

    void delete(Task task);

}

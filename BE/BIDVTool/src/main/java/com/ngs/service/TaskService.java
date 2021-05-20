package com.ngs.service;

import com.ngs.entity.Task;
import com.ngs.request.CreateTaskRequest;

import java.util.List;

public interface TaskService {
    Task save(CreateTaskRequest request) throws Exception;

    void delete(Task task);
    List<Task> getAll() throws Exception;
    Task getById(Integer id) throws Exception;

}

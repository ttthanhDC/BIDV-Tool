package com.ngs.service;

import com.ngs.entity.Task;

public interface TaskService {
    void save(Task task);

    void delete(Integer id);
}

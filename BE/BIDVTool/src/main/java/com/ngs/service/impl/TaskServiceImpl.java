package com.ngs.service.impl;

import com.ngs.constant.ErrorCode;
import com.ngs.entity.Operation;
import com.ngs.entity.Task;
import com.ngs.entity.User;
import com.ngs.exception.DefinedException;
import com.ngs.repository.OperationRepository;
import com.ngs.repository.TaskRepository;
import com.ngs.repository.UserRepository;
import com.ngs.request.CreateTaskRequest;
import com.ngs.response.CreatTaskResponse;
import com.ngs.service.TaskService;
import com.ngs.util.DateUtil;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OperationRepository operationRepository;

    @Override
    public List<Task> getAll() throws Exception {
        Iterable<Task> iterable = taskRepository.findAll();
        return IterableUtils.toList(iterable);
    }

    @Override
    public Task save(CreateTaskRequest request) throws Exception {
        Optional<User> optionalUser = userRepository.findById(request.getUserId());
        Optional<Operation> optionalOperation = operationRepository.findById(request.getOperationId());
        if (!optionalUser.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found user id " + request.getUserId());
        }
        if (!optionalOperation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation id " + request.getOperationId());
        }
        Task task = Task.builder()
                .assignee(optionalUser.get())
                .operation(optionalOperation.get())
                .description(request.getDescription())
                .mappingSheet(request.getMappingSheet())
                .status(request.getStatus())
                .openDate(DateUtil.fromString(request.getOpenDate()))
                .closeDate(DateUtil.fromString(request.getCloseDate()))
                .dueDate(DateUtil.fromString(request.getDueDate()))
                .build();
        taskRepository.save(task);
        return task;
    }
    @Override
    public Task getById(Integer id) throws Exception{
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + id);
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }
}

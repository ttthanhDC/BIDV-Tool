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
import com.ngs.request.UpdateTaskRequest;
import com.ngs.response.UpdateTaskResponse;
import com.ngs.service.TaskService;
import com.ngs.util.DateUtil;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
    public Task getById(Integer id) throws Exception {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + id);
    }

    @Override
    public Task save(CreateTaskRequest request) throws Exception {
        Pair<User, Operation> userOperationPair = validate(request.getUserId(), request.getOperationId());

        Task task = Task.builder()
                .assignee(userOperationPair.getLeft())
                .operation(userOperationPair.getRight())
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
    public UpdateTaskResponse update(UpdateTaskRequest request, Integer id) throws Exception {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()){
            throw new DefinedException(ErrorCode.NOT_FOUND, "fail to update task by id = "+id);
        }else {
            Pair<User, Operation> userOperationPair = validate(request.getUserId(), request.getOperationId());
            Task task = taskOptional.get();

            return null;
        }
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    private Pair<User, Operation> validate(Integer userId, Integer operationId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Operation> optionalOperation = operationRepository.findById(operationId);
        if (!optionalUser.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found user id " + userId);
        }
        if (!optionalOperation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation id " + operationId);
        }
        return new ImmutablePair<>(optionalUser.get(), optionalOperation.get());
    }
}

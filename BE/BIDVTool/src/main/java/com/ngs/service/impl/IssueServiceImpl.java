package com.ngs.service.impl;

import com.ngs.constant.ErrorCode;
import com.ngs.entity.OpenIssue;
import com.ngs.entity.Operation;
import com.ngs.entity.User;
import com.ngs.exception.DefinedException;
import com.ngs.repository.IssueRepository;
import com.ngs.repository.OperationRepository;
import com.ngs.repository.UserRepository;
import com.ngs.request.CreateIssueRequest;
import com.ngs.service.IssueService;
import com.ngs.util.DateUtil;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationRepository operationRepository;

    @Override
    public List<OpenIssue> getAll() {
        Iterable<OpenIssue> issues = issueRepository.findAll();
        return IterableUtils.toList(issues);
    }

    @Override
    public OpenIssue getById(Integer id) throws Exception {
        Optional<OpenIssue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found issue by id = " + id);
        }
        return issue.get();
    }

    @Override
    public OpenIssue save(CreateIssueRequest request) throws Exception {
        Optional<User> user = userRepository.findById(request.getUserId());
        Optional<Operation> operation = operationRepository.findById(request.getOperationId());
        if (!user.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found user by id = " + request.getUserId());
        }
        if (!operation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + request.getOperationId());
        }

        OpenIssue openIssue = OpenIssue.builder()
                .operation(operation.get())
                .openDate(DateUtil.fromString(request.getOpenDate()))
                .closeDate(DateUtil.fromString(request.getCloseDate()))
                .dueDate(DateUtil.fromString(request.getDueDate()))
                .status(request.getStatus())
                .comment(request.getComment())
                .description(request.getDescription())
                .reporter(user.get())
                .resolution(request.getResolution())
                .build();
        issueRepository.save(openIssue);
        return openIssue;
    }
}

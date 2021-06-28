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
import com.ngs.request.UpdateIssueRequest;
import com.ngs.response.UpdateIssueResponse;
import com.ngs.service.IssueService;
import com.ngs.util.DateUtil;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
        Pair<User, Operation> userOperationPair = validateBeforeSave(request.getReporterId(), request.getOperationId());
        OpenIssue openIssue = OpenIssue.builder()
                .operation(userOperationPair.getRight())
                .openDate(DateUtil.fromString(request.getOpenDate(), "yyyy-MM-dd"))
                .closeDate(DateUtil.fromString(request.getCloseDate(), "yyyy-MM-dd"))
                .dueDate(DateUtil.fromString(request.getDueDate(), "yyyy-MM-dd"))
                .status(request.getStatus())
                .comment(request.getComment())
                .jraNumber(request.getJraNumber())
                .description(request.getDescription())
                .reporter(userOperationPair.getLeft())
                .resolution(request.getResolution())
                .owner(request.getOwner())
                .support(request.getSupport())
                .build();
                issueRepository.save(openIssue);
        return openIssue;
    }

    @Override
    public UpdateIssueResponse update(UpdateIssueRequest request, Integer id) throws Exception {
        Optional<OpenIssue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "fail to update issue by id = " + id);
        } else {
            Pair<User, Operation> userOperationPair = validateBeforeSave(request.getReporterId(), request.getOperationId());

            OpenIssue updateIssue = issue.get();
            OpenIssue previousIssue = SerializationUtils.clone(updateIssue);
            updateIssue.setComment(request.getComment());
            updateIssue.setDescription(request.getDescription());
            updateIssue.setJraNumber(request.getJraNumber());
            updateIssue.setOpenDate(DateUtil.fromString(request.getOpenDate(), "yyyy-MM-dd"));
            updateIssue.setDueDate(DateUtil.fromString(request.getDueDate(), "yyyy-MM-dd"));
            updateIssue.setCloseDate(DateUtil.fromString(request.getCloseDate(), "yyyy-MM-dd"));
            updateIssue.setOperation(userOperationPair.getRight());
            updateIssue.setStatus(request.getStatus());
            updateIssue.setOwner(request.getOwner());
            updateIssue.setReporter(userOperationPair.getLeft());
            updateIssue.setResolution(request.getResolution());
            issueRepository.save(updateIssue);

            return UpdateIssueResponse.builder()
                    .previousIssue(previousIssue)
                    .updatedIssue(updateIssue)
                    .build();
        }
    }

    private Pair<User, Operation> validateBeforeSave(Integer userId, Integer operationId) throws DefinedException {
        Optional<User> user = userRepository.findById(userId);
        Optional<Operation> operation = operationRepository.findById(operationId);
        if (!user.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found user by id = " + userId);
        }
        if (!operation.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "not found operation by id = " + operationId);
        }
        return new ImmutablePair<>(user.get(), operation.get());
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<OpenIssue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            throw new DefinedException(ErrorCode.NOT_FOUND, "fail to delete issue by id = " + id);
        }
        issueRepository.delete(issue.get());
    }
}

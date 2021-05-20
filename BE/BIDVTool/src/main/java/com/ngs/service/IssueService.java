package com.ngs.service;

import com.ngs.entity.OpenIssue;
import com.ngs.exception.DefinedException;
import com.ngs.request.CreateIssueRequest;

import java.util.List;

public interface IssueService {
    List<OpenIssue> getAll();

    OpenIssue getById(Integer id) throws Exception;

    OpenIssue save(CreateIssueRequest issue) throws Exception;

}

package com.ngs.service;

import com.ngs.entity.OpenIssue;
import com.ngs.request.CreateIssueRequest;
import com.ngs.request.UpdateIssueRequest;
import com.ngs.response.UpdateIssueResponse;

import java.util.List;

public interface IssueService {
    List<OpenIssue> getAll();

    OpenIssue getById(Integer id) throws Exception;

    OpenIssue save(CreateIssueRequest issue) throws Exception;

    UpdateIssueResponse update(UpdateIssueRequest request, Integer id) throws Exception;

    void delete(Integer id) throws Exception;

}

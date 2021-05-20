package com.ngs.controller;

import com.ngs.entity.OpenIssue;
import com.ngs.exception.DefinedException;
import com.ngs.response.GetListIssueResponse;
import com.ngs.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    public ResponseEntity<GetListIssueResponse> getAll() {
        try {
            List<OpenIssue> issues = issueService.getAll();
            GetListIssueResponse response = GetListIssueResponse.builder()
                    .issues(issues)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

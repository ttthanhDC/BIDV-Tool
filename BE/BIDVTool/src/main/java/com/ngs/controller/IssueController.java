package com.ngs.controller;

import com.ngs.entity.OpenIssue;
import com.ngs.exception.DefinedException;
import com.ngs.request.CreateIssueRequest;
import com.ngs.request.UpdateIssueRequest;
import com.ngs.response.GetListIssueResponse;
import com.ngs.response.UpdateIssueResponse;
import com.ngs.response.bean.Issue;
import com.ngs.service.IssueService;
import com.ngs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/issue")
@CrossOrigin("*")
public class IssueController {

    @Autowired
    IssueService issueService;

    @GetMapping
    public ResponseEntity<GetListIssueResponse> getAll() {
        try {
            List<OpenIssue> openIssues = issueService.getAll();
            List<Issue> issues = new ArrayList<>();
            openIssues.forEach(i -> {
                Issue issue = Issue.builder()
                        .id(i.getId())
                        .closeDate(StringUtil.fromDate(i.getCloseDate(), "yyyy-MM-dd"))
                        .openDate(StringUtil.fromDate(i.getOpenDate(), "yyyy-MM-dd"))
                        .dueDate(StringUtil.fromDate(i.getDueDate(), "yyyy-MM-dd"))
                        .comment(i.getComment())
                        .description(i.getDescription())
                        .operation(i.getOperation())
                        .reporter(i.getReporter())
                        .owner(i.getOwner())
                        .resolution(i.getResolution())
                        .status(i.getStatus())
                        .build();
                issues.add(issue);
            });

            GetListIssueResponse response = GetListIssueResponse.builder()
                    .issues(issues)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getById(@PathVariable Integer id) {
        try {
            OpenIssue openIssue = issueService.getById(id);
            Issue issue = Issue.builder()
                    .id(openIssue.getId())
                    .closeDate(StringUtil.fromDate(openIssue.getCloseDate(), "yyyy-MM-dd"))
                    .openDate(StringUtil.fromDate(openIssue.getOpenDate(), "yyyy-MM-dd"))
                    .dueDate(StringUtil.fromDate(openIssue.getDueDate(), "yyyy-MM-dd"))
                    .comment(openIssue.getComment())
                    .description(openIssue.getDescription())
                    .operation(openIssue.getOperation())
                    .reporter(openIssue.getReporter())
                    .owner(openIssue.getOwner())
                    .resolution(openIssue.getResolution())
                    .status(openIssue.getStatus())
                    .build();
            return ResponseEntity.ok(issue);
        } catch (DefinedException e) {
            e.printStackTrace();
            HttpHeaders headers = new HttpHeaders();
            headers.add("resultCode", e.getCode());
            return ResponseEntity.badRequest().headers(headers).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<OpenIssue> insert(@RequestBody CreateIssueRequest request) {
        try {
            OpenIssue issue = issueService.save(request);
            return ResponseEntity.ok(issue);
        } catch (DefinedException e) {
            e.printStackTrace();
            HttpHeaders headers = new HttpHeaders();
            headers.add("resultCode", e.getCode());
            return ResponseEntity.badRequest().headers(headers).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateIssueResponse> update(@RequestBody UpdateIssueRequest request, @PathVariable Integer id) {
        try {
            UpdateIssueResponse response = issueService.update(request, id);
            return ResponseEntity.ok(response);
        } catch (DefinedException e) {
            e.printStackTrace();
            HttpHeaders headers = new HttpHeaders();
            headers.add("resultCode", e.getCode());
            return ResponseEntity.badRequest().headers(headers).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            issueService.delete(id);
            return ResponseEntity.ok("success");
        } catch (DefinedException e) {
            e.printStackTrace();
            HttpHeaders headers = new HttpHeaders();
            headers.add("resultCode", e.getCode());
            return ResponseEntity.badRequest().headers(headers).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

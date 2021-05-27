package com.ngs.controller;

import com.ngs.entity.Task;
import com.ngs.exception.DefinedException;
import com.ngs.request.CreateTaskRequest;
import com.ngs.request.UpdateTaskRequest;
import com.ngs.response.GetListTaskResponse;
import com.ngs.response.UpdateTaskResponse;
import com.ngs.service.TaskService;
import com.ngs.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
@Slf4j
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<GetListTaskResponse> getAll() {
        try {
            GetListTaskResponse response = new GetListTaskResponse();
            List<com.ngs.response.bean.Task> tasks = new ArrayList<>();
            List<Task> taskList = taskService.getAll();

            taskList.forEach(t -> {
                com.ngs.response.bean.Task task = buildTaskResponse(t);
                tasks.add(task);
            });
            response.setListTask(tasks);
            return ResponseEntity.ok(response);
        } catch (DefinedException e) {
            e.printStackTrace();
            HttpHeaders headers = new HttpHeaders();
            headers.add("resultCode", e.getCode());
            return ResponseEntity.badRequest().headers(headers).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<com.ngs.response.bean.Task> getById(@PathVariable Integer id) {
        try {
            Task task = taskService.getById(id);
            if (task != null) {
                return ResponseEntity.ok(buildTaskResponse(task));
            }
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody CreateTaskRequest request) {
        try {
            Task task = taskService.save(request);
            return ResponseEntity.ok(task);
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
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            Task task = taskService.getById(id);
            if (task != null) {
                taskService.delete(task);
                return ResponseEntity.ok().body(null);
            }
            return ResponseEntity.badRequest().body(null);

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
    public ResponseEntity<UpdateTaskResponse> update(@RequestBody UpdateTaskRequest request, @PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(taskService.update(request, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private com.ngs.response.bean.Task buildTaskResponse(Task t) {
        com.ngs.response.bean.Task task = com.ngs.response.bean.Task.builder()
                .id(t.getId())
                .assignee(t.getAssignee())
                .openDate(StringUtil.fromDate(t.getOpenDate(), "yyyy-MM-dd"))
                .dueDate(StringUtil.fromDate(t.getDueDate(), "yyyy-MM-dd"))
                .closeDate(StringUtil.fromDate(t.getCloseDate(), "yyyy-MM-dd"))
                .description(t.getDescription())
                .mappingSheet(t.getMappingSheet())
                .operation(t.getOperation())
                .status(t.getStatus())
                .build();
        return task;
    }
}

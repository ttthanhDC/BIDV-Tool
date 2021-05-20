package com.ngs.controller;

import com.ngs.entity.Task;
import com.ngs.request.CreateTaskRequest;
import com.ngs.response.CreatTaskResponse;
import com.ngs.response.GetListTaskResponse;
import com.ngs.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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
            response.setListTask(taskService.getAll());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Integer id) {
        try {
            Task task = taskService.getById(id);
            if (task != null) {
                return ResponseEntity.ok().body(task);
            }
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody CreateTaskRequest request) {
        try {
            return ResponseEntity.ok().body(taskService.save(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Task task = taskService.getById(id);
            if (task != null) {
                taskService.delete(task);
                return ResponseEntity.ok().body("success");
            }
            return  ResponseEntity.badRequest().body("not found operation");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

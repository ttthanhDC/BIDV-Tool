package com.ngs.controller;

import com.ngs.entity.Operation;
import com.ngs.request.CreateOperationRequest;
import com.ngs.response.GetListOperationResponse;
import com.ngs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
@CrossOrigin("*")
public class OperationController {

    @Autowired
    OperationService operationService;

    @GetMapping
    public ResponseEntity<GetListOperationResponse> getAll() {
        try {
            List<Operation> listOperation = operationService.findAll();
            GetListOperationResponse response = new GetListOperationResponse();
            response.setOperations(listOperation);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> findById(@PathVariable Integer id) {
        try {
            Operation operation = operationService.findById(id);
            if (operation != null) {
                return ResponseEntity.ok().body(operation);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Operation> createOperation(@RequestBody CreateOperationRequest createOperationRequest) {
        try {
            Operation operation = operationService.save(createOperationRequest);
            return ResponseEntity.ok().body(operation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

package com.ngs.controller;

import com.ngs.entity.Operation;
import com.ngs.exception.DefinedException;
import com.ngs.request.CreateOperationRequest;
import com.ngs.request.UpdateOperationRequest;
import com.ngs.response.GetListOperationResponse;
import com.ngs.response.UpdateOperationResponse;
import com.ngs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

            return ResponseEntity.ok(response);
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
                return ResponseEntity.ok(operation);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Operation> create(@RequestBody CreateOperationRequest createOperationRequest) {
        try {
            Operation operation = operationService.save(createOperationRequest);
            return ResponseEntity.ok(operation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOperationResponse> update(@RequestBody UpdateOperationRequest updateRequest, @PathVariable Integer id) {
        try {
            UpdateOperationResponse updateResponse = operationService.update(updateRequest, id);
            return ResponseEntity.ok(updateResponse);
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
            operationService.delete(id);
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

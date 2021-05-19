package com.ngs.controller;

import com.ngs.entity.Operation;
import com.ngs.response.GetListOperationResponse;
import com.ngs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operation")
@CrossOrigin("*")
public class OperationController {

    @Autowired
    OperationService operationService;

    public ResponseEntity<GetListOperationResponse> getAll(){
        try {
            List<Operation> listOperation = operationService.findAll();
            GetListOperationResponse response = new GetListOperationResponse();
            response.setOperations(listOperation);

            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

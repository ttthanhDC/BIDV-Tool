package com.ngs.controller;

import com.ngs.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping(value = "/app")
    public ResponseEntity<List<Map<Object, Object>>> getTotalApp() {
        try {
            List<Map<Object, Object>> totalApp = dashboardService.getTotalApp();
            return ResponseEntity.ok(totalApp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/operation", params = "query=status")
    public ResponseEntity<List<Map<Object, Object>>> getTotalOperationByStatus(@RequestParam Integer serviceId, @RequestParam Integer appId) {
        try {
            List<Map<Object, Object>> totalApp = dashboardService.getTotalOperationByStatus(serviceId, appId);
            return ResponseEntity.ok(totalApp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

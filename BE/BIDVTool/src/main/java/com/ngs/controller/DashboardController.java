package com.ngs.controller;

import com.ngs.entity.Operation;
import com.ngs.entity.Service;
import com.ngs.response.bean.*;
import com.ngs.service.DashboardService;
import com.ngs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping(value = "/app", params = "query=service")
    public ResponseEntity<TotalAppByService> getTotalAppByService() {
        try {
            TotalAppByService totalAppBySer = dashboardService.getTotalAppByService();
            return ResponseEntity.ok(totalAppBySer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/operation", params = "query=status")
    public ResponseEntity<List<Map<Object, Object>>> getTotalOperationByStatus(@RequestParam(required = false) Integer serviceId, @RequestParam(required = false) Integer appId) {
        try {
            List<Map<Object, Object>> totalApp = dashboardService.getTotalOperationByStatus(serviceId, appId);
            return ResponseEntity.ok(totalApp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/operation", params = "query=service")
    public ResponseEntity<TotalOperationByService> getTotalOperationByService() {
        try {
            TotalOperationByService totalOperationByService = dashboardService.getTotalOprByService();
            return ResponseEntity.ok(totalOperationByService);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/service", params = "query=app")
    public ResponseEntity<TotalGetServiceByApp> getTotalServiceByApp() {
        try {
            TotalGetServiceByApp totalServiceByApp = dashboardService.getTotalServiceByApp();
            return ResponseEntity.ok(totalServiceByApp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/service", params = "query=status")
    public ResponseEntity<List<Map<Object, Object>>> getTotalServiceByStatus() {
        try {
            List<Map<Object, Object>> totalServiceByStatus = dashboardService.getTotalServiceByStatus();
            return ResponseEntity.ok(totalServiceByStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/operation", params = "service")
    public ResponseEntity<List<OperationResponse>> getOperationByServiceId(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("service"));
            List<OperationResponse> listOperation = dashboardService.getTotalOperationByService(id);
            if (listOperation != null) {
                return ResponseEntity.ok().body(listOperation);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/service", params = "app")
    public ResponseEntity<List<ServiceByApp>> getServiceByAppId(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("app"));
            List<ServiceByApp> listService = dashboardService.getServiceByAppId(id);
            if (listService != null) {
                return ResponseEntity.ok().body(listService);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/task", params = "query=operation")
    public ResponseEntity<TotalTaskByOperation> getTotalSTaskByOperation() {
        try {
            TotalTaskByOperation totalTaskByOperation = dashboardService.getTotalTaskByService();
            return ResponseEntity.ok(totalTaskByOperation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/task", params = "operationId")
    public ResponseEntity<List<DoingTask>> getTasksDoingByOperationId(HttpServletRequest request) {
        try {
            int operationId = Integer.parseInt(request.getParameter("operationId"));
            List<DoingTask> listTask = dashboardService.getTasksDoingByOperationId(operationId);
            if (listTask != null) {
                return ResponseEntity.ok().body(listTask);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

package com.ngs.controller;

import com.ngs.repository.DashBoardRepository;
import com.ngs.response.ServiceChartResponse;
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

    @PostMapping(value = "/service", params = "status=success")
    public ResponseEntity<ServiceChartResponse> getSuccessServiceChart() {
        try {
            List<Map<String, Double>> data = dashboardService.successServices();
            ServiceChartResponse response = ServiceChartResponse.builder()
                    .dataList(data)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

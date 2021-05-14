package com.ngs.controller;

import com.ngs.entity.Application;
import com.ngs.request.CreateApplicationRequest;
import com.ngs.response.CreateApplicationResponse;
import com.ngs.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/app")
@Slf4j
@CrossOrigin("*")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<CreateApplicationResponse> insert(HttpServletRequest httpRequest, @RequestBody CreateApplicationRequest request) {
        try {
            // TODO get request header params

            Application application = Application.builder()
                    .bidvAppCode(request.getBidvAppCode())
                    .applicationName(request.getApplicationName())
                    .abbreviation(request.getAbbreviation())
                    .integrationAppCode(request.getIntegrationAppCode())
                    .build();
            applicationService.creatApplication(application);
            CreateApplicationResponse response = CreateApplicationResponse.builder()
                    .bidvAppCode(application.getBidvAppCode())
                    .applicationName(application.getApplicationName())
                    .abbreviation(application.getAbbreviation())
                    .integrationAppCode(application.getIntegrationAppCode())
                    .build();
            // TODO add to base
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("resultCode", "0");
            responseHeader.add("resultDesc", "success");
            responseHeader.add("responseTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            return ResponseEntity.ok().headers(responseHeader).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

package com.ngs.controller;

import com.ngs.entity.Application;
import com.ngs.request.CreateApplicationRequest;
import com.ngs.request.UpdateApplicationRequest;
import com.ngs.response.CreateApplicationResponse;
import com.ngs.response.GetListApplicationResponse;
import com.ngs.response.UpdateApplicationResponse;
import com.ngs.service.ApplicationService;
import com.ngs.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/application")
@Slf4j
@CrossOrigin("*")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<GetListApplicationResponse> findAll() {
        GetListApplicationResponse response = new GetListApplicationResponse();
        try {
            List<Application> applicationList = applicationService.getAll();
            response.setApplications(applicationList);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("resultCode", "0");
            responseHeader.add("resultDesc", "success");
            responseHeader.add("responseTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            return ResponseEntity.ok().headers(responseHeader).body(response);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> findById(@PathVariable Integer id) {
        try {
            Application application = applicationService.getById(id);
            if (application != null) {
                log.info(String.format("[%s] response: %s", "findById", StringUtil.toJsonString(application)));
                return ResponseEntity.ok(application);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<CreateApplicationResponse> insert(@RequestBody CreateApplicationRequest request) {
        try {
            // TODO validate request
            Application application = Application.builder()
                    .bidvAppCode(request.getBidvAppCode())
                    .applicationName(request.getApplicationName())
                    .abbreviation(request.getAbbreviation())
                    .integrationAppCode(request.getIntegrationAppCode())
                    .inScope(request.isInScope())
                    .build();
            applicationService.save(application);
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

    @PutMapping("/{id}")
    public ResponseEntity<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest request, @PathVariable Integer id) {
        UpdateApplicationResponse response = UpdateApplicationResponse.builder().build();
        try {

            // TODO validate request
            Application application = applicationService.getById(id);
            Application previousApp = SerializationUtils.clone(application);
            if (application == null) {
                return ResponseEntity.badRequest().body(null);
            }
            application.setApplicationName(request.getApplicationName());
            application.setAbbreviation(request.getAbbreviation());
            application.setBidvAppCode(request.getBidvAppCode());
            application.setIntegrationAppCode(request.getIntegrationAppCode());
            application.setInScope(request.isInScope());

            applicationService.save(application);
            response.setPreviousApplication(previousApp);
            response.setUpdatedApplication(application);
            // TODO add to base
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("resultCode", "0");
            responseHeader.add("resultDesc", "success");
            responseHeader.add("responseTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            log.info("[update] response: " + StringUtil.toJsonString(response));
            return ResponseEntity.ok().headers(responseHeader).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            Application application = applicationService.getById(id);
            if (application != null) {
                applicationService.delete(application);
            }
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

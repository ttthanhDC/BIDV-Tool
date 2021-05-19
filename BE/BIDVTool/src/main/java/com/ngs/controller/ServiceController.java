package com.ngs.controller;

import com.ngs.entity.Services;
import com.ngs.request.CreatServicesRequest;
import com.ngs.request.UpdateServicesRequest;
import com.ngs.response.CreatServiceResponse;
import com.ngs.response.GetListServiceResponse;
import com.ngs.response.UpdateServiceResponse;
import com.ngs.service.ServicesService;
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
@Slf4j
@RequestMapping("/service")
@CrossOrigin("*")
public class ServiceController {
    @Autowired
    ServicesService service;

    @GetMapping
    public ResponseEntity<GetListServiceResponse> getAll() {
        GetListServiceResponse response = new GetListServiceResponse();
        try {
            List<Services> listServices = service.getAll();
            response.setList(listServices);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("resultCode", "0");
            responseHeader.add("resultDesc", "success");
            responseHeader.add("responseTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            return ResponseEntity.ok().headers(responseHeader).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getById(@PathVariable Integer id) {
        try {
            Services services = service.getById(id);
            if (services != null) {
                log.info(String.format("[%s] response: %s", "findById", StringUtil.toJsonString(services)));
                return ResponseEntity.ok().body(services);
            }
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<CreatServiceResponse> insert(@RequestBody CreatServicesRequest request) {
        log.info("start insert");
        try {
            Services services = Services.builder()
                    .serviceName(request.getServiceName())
                    .status(request.getStatus())
                    .build();
            service.save(services);
            CreatServiceResponse response = CreatServiceResponse.builder()
                    .ServiceName(request.getServiceName())
                    .status(request.getStatus())
                    .build();
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
    public ResponseEntity<UpdateServiceResponse> update(@RequestBody UpdateServicesRequest request, @PathVariable Integer id) {
        UpdateServiceResponse response = UpdateServiceResponse.builder().build();
        try {
            Services services = service.getById(id);
            Services previousSer = SerializationUtils.clone(services);
            if (services == null) {
                return ResponseEntity.badRequest().body(null);
            }
            services.setServiceName(request.getServiceName());
            services.setStatus(request.getStatus());
            service.save(services);
            response.setUpdateService(services);
            response.setPreviousService(previousSer);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            Services services = service.getById(id);
            if (services != null) {
                service.delete(services);
                return ResponseEntity.ok().body("ok");
            }
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

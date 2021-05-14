package com.ngs.controller;

import com.ngs.constant.ResultCode;
import com.ngs.entity.Application;
import com.ngs.request.CreatApplicationRequest;
import com.ngs.request.CreatApplicationRequestBody;
import com.ngs.response.BaseResponse;
import com.ngs.response.CreatApplicationResponseBody;
import com.ngs.response.ResponseHeader;
import com.ngs.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Slf4j
@CrossOrigin("*")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<BaseResponse<CreatApplicationResponseBody>> insert(@RequestBody CreatApplicationRequest request) {
        ResponseHeader responseHeader = ResponseHeader.builder().resultCode(ResultCode.COMMON_ERROR).build();
        BaseResponse<CreatApplicationResponseBody> response = new BaseResponse<>();
        response.setResponseHeader(responseHeader);
        try {
            CreatApplicationRequestBody requestBody = request.getRequestBody();
            Application application = Application.builder()
                    .bidvAppCode(requestBody.getBidvAppCode())
                    .applicationName(requestBody.getApplicationName())
                    .abbreviation(requestBody.getAbbreviation())
                    .integrationAppCode(requestBody.getIntegrationAppCode())
                    .build();
            applicationService.creatApplication(application);
            CreatApplicationResponseBody responseBody = CreatApplicationResponseBody.builder()
                    .bidvAppCode(application.getBidvAppCode())
                    .applicationName(application.getApplicationName())
                    .abbreviation(application.getAbbreviation())
                    .integrationAppCode(application.getIntegrationAppCode())
                    .build();
            response.setResponseBody(responseBody);
            responseHeader.setResultCode(ResultCode.SUCCESS);
            return  new ResponseEntity<>(response,HttpStatus.OK);

        } catch (Exception e){
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

package com.ngs.controller;

import com.ngs.constant.ResultCode;
import com.ngs.constant.Status;
import com.ngs.request.ImportExcelRequest;
import com.ngs.response.BaseResponse;
import com.ngs.response.ImportExcelResponseBody;
import com.ngs.response.ResponseHeader;
import com.ngs.service.GetExcelDataService;
import com.ngs.service.ImportExcelServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/upload")
@Slf4j
@CrossOrigin("*")
public class ImportExcelController {

    @Autowired
    GetExcelDataService getExcelDataService;

    @PostMapping
    public ResponseEntity<BaseResponse<ImportExcelResponseBody>> importExcel(@RequestParam MultipartFile file, @RequestParam String function) {
        BaseResponse<ImportExcelResponseBody> response = new BaseResponse<ImportExcelResponseBody>();
        ResponseHeader responseHeader = ResponseHeader.builder()
                .resultCode(ResultCode.COMMON_ERROR)
                .responseTime(new Date())
                .build();
        response.setResponseHeader(responseHeader);
        try (InputStream inputStream = file.getInputStream()) {
            ImportExcelRequest importRequest = ImportExcelServiceFactory.getImportService(function).getImportRequest();
            importRequest.setInputStream(inputStream);
            List<Triple<Integer, Integer, Object>> data = getExcelDataService.getExcelData(importRequest);

            // TODO insert data into DB
            responseHeader.setResultCode(ResultCode.SUCCESS);
            responseHeader.setResponseTime(new Date());
            ImportExcelResponseBody responseBody = ImportExcelResponseBody.builder()
                    .status(Status.STATUS_SUCCESS)
                    .totalRecord(data.size())
                    .build();
            response.setResponseBody(responseBody);
        } catch (Exception e) {
            new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

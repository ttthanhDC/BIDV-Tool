package com.ngs.controller;

import com.ngs.service.GetExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
@Slf4j
@CrossOrigin("*")
public class ImportExcelController {

    @Autowired
    GetExcelDataService getExcelDataService;

//    @PostMapping
//    public ResponseEntity<ImportExcelResponse> importExcel(@RequestParam MultipartFile file, @RequestParam String function) {
//        ImportExcelResponse response = new ImportExcelResponse();
//        ResponseHeader responseHeader = ResponseHeader.builder()
//                .resultCode(ResultCode.COMMON_ERROR)
//                .responseTime(new Date())
//                .build();
//        response.setResponseHeader(responseHeader);
//        try (InputStream inputStream = file.getInputStream()) {
//            ImportExcelRequest importRequest = ImportExcelServiceFactory.getImportService(function).getImportRequest();
//            importRequest.setInputStream(inputStream);
//            List<Triple<Integer, Integer, Object>> data = getExcelDataService.getExcelData(importRequest);
//
//            // TODO insert data into DB
//            responseHeader.setResultCode(ResultCode.SUCCESS);
//            responseHeader.setResponseTime(new Date());
//            ImportExcelResponseBody responseBody = ImportExcelResponseBody.builder()
//                    .status(Status.STATUS_SUCCESS)
//                    .totalRecord(data.size())
//                    .build();
//            response.setResponseBody(responseBody);
//        } catch (Exception e) {
//            new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


}

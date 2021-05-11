package com.ngs.controller;

import com.ngs.response.BaseResponse;
import com.ngs.response.ResponseHeader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ResponseEntity<BaseResponse> test() {
        ResponseHeader responseHeader = ResponseHeader.builder()
                .resultCode("0")
                .resultDesc("success")
                .responseTime(new Date())
                .build();
        BaseResponse response = BaseResponse.builder()
                .responseHeader(responseHeader)
                .responseBody("Hello World!")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.ngs.controller;

import com.ngs.constant.ResultCode;
import com.ngs.entity.User;
import com.ngs.request.BaseRequest;
import com.ngs.request.CreateUserRequestBody;
import com.ngs.response.BaseResponse;
import com.ngs.response.CreateUserResponseBody;
import com.ngs.response.ResponseHeader;
import com.ngs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponse<CreateUserResponseBody>> insert(@RequestBody BaseRequest<CreateUserRequestBody> request) {
        ResponseHeader responseHeader = ResponseHeader.builder().resultCode(ResultCode.COMMON_ERROR).build();
        BaseResponse<CreateUserResponseBody> response = new BaseResponse<>();
        response.setResponseHeader(responseHeader);
        try {
            CreateUserRequestBody requestBody = request.getRequestBody();
            User user = User.builder()
                    .userName(requestBody.getUserName())
                    .fullName(requestBody.getFullName())
                    .status(requestBody.getStatus())
                    .email(requestBody.getEmail())
                    .build();
            userService.createUser(user);
            CreateUserResponseBody responseBody = CreateUserResponseBody.builder()
                    .userName(user.getUserName())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .build();
            response.setResponseBody(responseBody);
            responseHeader.setResultCode(ResultCode.SUCCESS);
            responseHeader.setResultDesc("success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

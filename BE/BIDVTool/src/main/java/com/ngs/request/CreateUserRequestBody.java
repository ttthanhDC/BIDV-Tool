package com.ngs.request;

import lombok.Data;

@Data
public class CreateUserRequestBody {
    private String userName;
    private String fullName;
    private String status;
    private String email;
}

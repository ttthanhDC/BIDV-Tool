package com.ngs.response;


import lombok.Data;

@Data
public abstract class BaseResponse<T> {
    private ResponseHeader responseHeader;
    private T responseBody;
}

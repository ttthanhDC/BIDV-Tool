package com.ngs.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse<T> {
    private ResponseHeader responseHeader;
    private T responseBody;
}

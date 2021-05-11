package com.ngs.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse<T> {

    private ResponseHeader responseHeader;
    private T responseBody;
}

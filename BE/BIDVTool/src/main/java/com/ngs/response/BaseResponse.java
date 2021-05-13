package com.ngs.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
public class BaseResponse<T> {
    private ResponseHeader responseHeader;
    private T responseBody;
}

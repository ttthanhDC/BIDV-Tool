package com.ngs.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class ResponseHeader {
    private String resultCode;
    private String resultDesc;
    private Date responseTime;
}

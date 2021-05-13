package com.ngs.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHeader {
    private String resultCode;
    private String resultDesc;
    private Date responseTime;
}

package com.ngs.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatApplicationResponseBody {
    private String bidvAppCode;
    private String integrationAppCode;
    private String applicationName;
    private String abbreviation;
}

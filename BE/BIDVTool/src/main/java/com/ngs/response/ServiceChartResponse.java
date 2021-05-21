package com.ngs.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ServiceChartResponse {
    List<Map<String, Double>> dataList;
}

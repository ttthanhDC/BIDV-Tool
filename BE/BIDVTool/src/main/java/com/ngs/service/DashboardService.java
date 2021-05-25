package com.ngs.service;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);

}

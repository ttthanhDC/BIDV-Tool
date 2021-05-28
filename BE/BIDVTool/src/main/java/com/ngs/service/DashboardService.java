package com.ngs.service;

import com.ngs.entity.Operation;
import com.ngs.response.bean.DoingTask;
import com.ngs.response.bean.OperationResponse;
import com.ngs.response.bean.ServiceByApp;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);
    List<Map<Object, Object>> getTotalOperationByService();
    List<Map<Object,Object>> getTotalAppByService();
    List<Map<Object, Object>> getTotalServiceByApp();
    List<Map<Object, Object>> getTotalServiceByStatus();
    List<OperationResponse> getTotalOperationByService(Integer serviceId);
    List<ServiceByApp> getServiceByAppId(Integer appId);

    List<Map<Object, Object>> getTotalTaskByService();
    List<DoingTask> getTasksDoingByOperationId(Integer operationId);
}

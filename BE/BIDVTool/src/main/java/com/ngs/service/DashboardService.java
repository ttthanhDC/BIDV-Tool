package com.ngs.service;

import com.ngs.entity.OpenIssue;
import com.ngs.entity.Operation;
import com.ngs.response.bean.*;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);
    List<Map<Object, Object>> getTotalOperationByService();
    TotalAppByService getTotalAppByService();
    TotalOperationByService getTotalOprByService();
    TotalGetServiceByApp getTotalServiceByApp();
    List<Map<Object, Object>> getTotalServiceByStatus();
    List<OperationResponse> getTotalOperationByService(Integer serviceId,Integer applicationId);
    List<ServiceByApp> getServiceByAppId(Integer appId);

    TotalTaskByOperation getTotalTaskByService();
    List<DoingTask> getTasksDoingByOperationId(Integer operationId);
    List<OpenIssue> getOpenIssueByParams(Integer operationId,String status);
    List<TotalOperationByApp> getTotalOperationByApp();
}

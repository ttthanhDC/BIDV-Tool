package com.ngs.repository;

import com.ngs.entity.OpenIssue;
import com.ngs.entity.Operation;
import com.ngs.response.bean.*;

import java.util.List;
import java.util.Map;

public interface DashBoardRepository {
    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);
    List<Map<Object, Object>> getTotalOperationByService();
    TotalAppByService getTotalAppByService();
    TotalOperationByService getTotalOprByService();
    TotalGetServiceByApp getTotalServiceByApp();
    List<Map<Object, Object>> getTotalServiceByStatus();
    List<OperationResponse> getTotalOperationByServiceId(Integer serviceId,Integer appId);

    List<ServiceByApp> getServiceByAppId(Integer appid);

    TotalTaskByOperation getTotalTaskByOperation();
    List<DoingTask> getTasksDoingByOperationId(Integer operationId);
    List<OpenIssue> getOpenIssueByParams(Integer OperationId,String status);
    List<TotalOperationByApp> getTotalOperationByApp();
}








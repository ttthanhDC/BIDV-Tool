package com.ngs.repository;

import com.ngs.entity.Operation;
import com.ngs.response.bean.OperationResponse;
import com.ngs.response.bean.ServiceByApp;

import java.util.List;
import java.util.Map;

public interface DashBoardRepository {
    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);
    List<Map<Object, Object>> getTotalOperationByService();
    List<Map<Object,Object>> getTotalAppByService();
    List<Map<Object, Object>> getTotalServiceByApp();
    List<Map<Object, Object>> getTotalServiceByStatus();
    List<OperationResponse> getTotalOperationByServiceId(Integer serviceId);

    List<ServiceByApp> getServiceByAppId(Integer appid);

    List<Map<Object, Object>> getTotalTaskByOperation();
}








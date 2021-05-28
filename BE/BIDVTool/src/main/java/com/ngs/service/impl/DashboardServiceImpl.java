package com.ngs.service.impl;

import com.ngs.entity.Operation;
import com.ngs.repository.DashBoardRepository;
import com.ngs.response.bean.DoingTask;
import com.ngs.response.bean.OperationResponse;
import com.ngs.response.bean.ServiceByApp;
import com.ngs.response.bean.TotalAppResponse;
import com.ngs.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    DashBoardRepository dashBoardRepository;


    @Override
    public List<Map<Object, Object>> getTotalApp() {
        return dashBoardRepository.getTotalApp();
    }

    @Override
    public List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId) {
        return dashBoardRepository.getTotalOperationByStatus(serviceId, appId);
    }

    @Override
    public List<Map<Object, Object>> getTotalOperationByService() {
        return dashBoardRepository.getTotalOperationByService();
    }

    @Override
    public List<Map<Object, Object>> getTotalAppByService() {
        return dashBoardRepository.getTotalAppByService();
    }

    @Override
    public List<Map<Object, Object>> getTotalServiceByApp() {
        return dashBoardRepository.getTotalServiceByApp();
    }

    @Override
    public List<Map<Object, Object>> getTotalServiceByStatus() {
        return dashBoardRepository.getTotalServiceByStatus();
    }

    @Override
    public List<OperationResponse> getTotalOperationByService(Integer serviceId) {
        return dashBoardRepository.getTotalOperationByServiceId(serviceId);
    }

    @Override
    public List<ServiceByApp> getServiceByAppId(Integer appid) {
        return dashBoardRepository.getServiceByAppId(appid);
    }

    @Override
    public List<Map<Object, Object>> getTotalTaskByService() {
        return dashBoardRepository.getTotalTaskByOperation();
    }
    @Override
    public List<DoingTask> getTasksDoingByOperationId(Integer operationId){
        return dashBoardRepository.getTasksDoingByOperationId(operationId);
    }
}


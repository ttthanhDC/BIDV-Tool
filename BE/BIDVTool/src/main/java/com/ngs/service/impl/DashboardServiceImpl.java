package com.ngs.service.impl;

import com.ngs.entity.OpenIssue;
import com.ngs.repository.DashBoardRepository;
import com.ngs.response.bean.*;
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
    public TotalAppByService getTotalAppByService() {
        return dashBoardRepository.getTotalAppByService();
    }

    @Override
    public TotalOperationByService getTotalOprByService() {
        return dashBoardRepository.getTotalOprByService();
    }

    @Override
    public TotalGetServiceByApp getTotalServiceByApp() {
        return dashBoardRepository.getTotalServiceByApp();
    }

    @Override
    public List<Map<Object, Object>> getTotalServiceByStatus() {
        return dashBoardRepository.getTotalServiceByStatus();
    }

    @Override
    public List<OperationResponse> getTotalOperationByService(Integer serviceId,Integer appID) {
        return dashBoardRepository.getTotalOperationByServiceId(serviceId,appID);
    }

    @Override
    public List<ServiceByApp> getServiceByAppId(Integer appid) {
        return dashBoardRepository.getServiceByAppId(appid);
    }

    @Override
    public TotalTaskByOperation getTotalTaskByService() {
        return dashBoardRepository.getTotalTaskByOperation();
    }
    @Override
    public List<DoingTask> getTasksDoingByOperationId(Integer operationId){
        return dashBoardRepository.getTasksDoingByOperationId(operationId);
    }

    @Override
    public List<OpenIssue> getOpenIssueByParams(Integer operationId, String status) {
        return dashBoardRepository.getOpenIssueByParams(operationId,status);
    }
    @Override
    public  List<TotalOperationByApp> getTotalOperationByApp(){
        return dashBoardRepository.getTotalOperationByApp();
    }
}

